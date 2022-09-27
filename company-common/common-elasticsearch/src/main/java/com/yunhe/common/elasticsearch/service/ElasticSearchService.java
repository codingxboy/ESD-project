package com.yunhe.common.elasticsearch.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.common.util.Maps;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.aggregations.bucket.histogram.Histogram;
import org.elasticsearch.search.aggregations.bucket.histogram.ParsedDateHistogram;
import org.elasticsearch.search.aggregations.metrics.CardinalityAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.ParsedCardinality;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName ElasticSearchService
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/9/22 15:42
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor
public class ElasticSearchService {

    private final RestHighLevelClient restHighLevelClient;
    /**
     * @description: 计数
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/22 17:31
     */
    @SneakyThrows
    public long count(QueryBuilder queryBuilder,String... indices){
        //构造请求
        CountRequest countRequest = new CountRequest(indices);
        countRequest.query(queryBuilder);

        //执行请求
        CountResponse countResponse = restHighLevelClient.count(countRequest, RequestOptions.DEFAULT);
        long count = countResponse.getCount();
        return count;

    }
    /**
     * @description: 去重计数
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/22 16:33
     */
    @SneakyThrows
    public long countDistinct(QueryBuilder queryBuilder,String field,String... indices){
        //自定义去重
        String distinctKey="distinctKey";
        //构造计数聚合
        CardinalityAggregationBuilder aggregationBuilder = AggregationBuilders.cardinality(distinctKey).field(field);
        //构造搜索源
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder).aggregation(aggregationBuilder);
        //构造请求
        SearchRequest searchRequest = new SearchRequest(indices);
        searchRequest.source(searchSourceBuilder);
        //执行请求
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        ParsedCardinality result = searchResponse.getAggregations().get(distinctKey);
        return result.getValue();
    }
    /**
     * @description: 日期聚合统计
     * @param queryBuilder 查询条件
     * @param field        聚合字段，如：登录日志的 date 字段
     * @param interval     统计时间间隔，如：1天、1周
     * @param indices      索引名称
     * @author xiaozuqin
     * @date: 2022/9/22 16:31
     */
    @SneakyThrows
    public Map<String, Long> dateHistogram(QueryBuilder queryBuilder, String field, DateHistogramInterval interval,String... indices){
        //自定义日期聚合key，保证上下文一致
        String dateHistogramKey = "dateHistogramKey";
        //构造聚合
        AggregationBuilder aggregationBuilder=AggregationBuilders
                //自定义统计名，和下文获取需一致
                .dateHistogram(dateHistogramKey)
                // 日期字段名
                .field(field)
                // 时间格式
                .format("yyyy-mm-dd hh:mm:ss")
                // 日历间隔，例： 1s->1秒 1d->1天 1w->1周 1M->1月 1y->1年 ...
                .calendarInterval(interval)
                // 最小文档数
                .minDocCount(0);
        //构造搜索源
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder)
                .aggregation(aggregationBuilder)
                .size(0);
        //构造搜索请求
        SearchRequest searchRequest = new SearchRequest(indices);
        searchRequest.source(searchSourceBuilder);
        searchRequest.indicesOptions(IndicesOptions.fromOptions(true,
        true, true, false));
        //执行请求
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //处理结果
        ParsedDateHistogram dateHistogram = searchResponse.getAggregations().get(dateHistogramKey);
        Iterator<? extends Histogram.Bucket> iterator = dateHistogram.getBuckets().iterator();
        Map<String, Long> map = new HashMap<>();
        while (iterator.hasNext()){
            Histogram.Bucket bucket = iterator.next();
            map.put(bucket.getKeyAsString(), bucket.getDocCount());
        }
        return map;

    }

    /**
     * 列表查询
     */
    @SneakyThrows
    public <T extends BaseDocument> List<T> search(QueryBuilder queryBuilder, Class<T> clazz, String... indices) {
        List<T> list = this.search(queryBuilder, null, 1, 30, clazz, indices);
        return list;
    }

    /**
     * @description: 分页列表查询
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/22 17:08
     */
    @SneakyThrows
    public <T extends BaseDocument> List<T> search(QueryBuilder queryBuilder, SortBuilder sortBuilder,Integer page,Integer size,Class<T> clazz,String... indices){
        //构造搜索源请求
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.sort(sortBuilder);
        searchSourceBuilder.from((page-1)*size);
        searchSourceBuilder.size(size);
        //构造搜索请求
        SearchRequest searchRequest = new SearchRequest(indices);
        searchRequest.source(searchSourceBuilder);
        //执行请求
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        SearchHit[] hitsHits = hits.getHits();
        List<T> list = CollectionUtil.newArrayList();
        for (SearchHit searchHits:hitsHits){
            T t = JSONUtil.toBean(searchHits.getSourceAsString(), clazz);
            t.setId(searchHits.getId());
            t.setIndex(searchHits.getIndex());
            list.add(t);
        }
        return list;
    }
    /**
     * @description: 删除
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/9/22 21:18
     */
    @SneakyThrows
    public boolean deleteIndexById(String id,String index){
        DeleteRequest deleteRequest = new DeleteRequest();
        restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        return true;
    }

    @Data
    public static class BaseDocument {

        /**
         * 数据唯一标识
         */
        private String id;

        /**
         * 索引名称
         */
        private String index;
    }

    @Data
    public class LoginRecord extends BaseDocument {

        private String clientIp;

        private long elapsedTime;

        private Object message;

        private String token;

        private String userName;

        private String loginTime;

        private String region;

        /**
         * 会话状态 0-离线 1-在线
         */
        private Integer status;

    }
}
