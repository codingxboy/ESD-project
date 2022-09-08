package com.yunhe.company.oa.domain.common.utils;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.yunhe.common.core.util.SpringContextUtil;
import com.yunhe.common.core.util.oConvertUtil;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * @ClassName DatasourceUtil
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/8/24 16:13
 * @Version 1.0
 */
public class DatasourceUtil {
    /**
     * 根据数据源key获取DataSourceProperty
     * @param sourceKey
     * @return
     */
    public static DataSourceProperty getDataSourceProperty(String sourceKey){
        DynamicDataSourceProperties prop = SpringContextUtil.getApplicationContext().getBean(DynamicDataSourceProperties.class);
        Map<String, DataSourceProperty> map = prop.getDatasource();
        DataSourceProperty db = (DataSourceProperty)map.get(sourceKey);
        return db;
    }

    /**
     * 根据sourceKey 获取数据源连接
     * @param sourceKey
     * @return
     * @throws SQLException
     */
    public static Connection getDataSourceConnect(String sourceKey) throws SQLException {
        if (oConvertUtil.isEmpty(sourceKey)) {
            sourceKey = "master";
        }
        DynamicDataSourceProperties prop = SpringContextUtil.getApplicationContext().getBean(DynamicDataSourceProperties.class);
        Map<String, DataSourceProperty> map = prop.getDatasource();
        DataSourceProperty db = (DataSourceProperty)map.get(sourceKey);
        if(db==null){
            return null;
        }
        DriverManagerDataSource ds = new DriverManagerDataSource ();
        ds.setDriverClassName(db.getDriverClassName());
        ds.setUrl(db.getUrl());
        ds.setUsername(db.getUsername());
        ds.setPassword(db.getPassword());
        return ds.getConnection();
    }
}
