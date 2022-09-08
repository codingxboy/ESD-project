package com.yunhe.company.erp.common.redis;

import com.yunhe.common.core.constants.BusinessConstants;
import com.yunhe.common.core.util.StringUtil;
import com.yunhe.common.web.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisService
 * @Description TODO redis服务
 * @Author xiaozuqin
 * @Date 2022/7/26 10:09
 * @Version 1.0
 */
@Component
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;
//    private static final String ACCESS_TOKEN="X-Access-Token";

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate){
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        this.redisTemplate=redisTemplate;
    }
    /**
     * @description: 从session中获取信息
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/26 10:17
     */
    public Object getObjectFromSessionByKey(HttpServletRequest httpServletRequest,String key) {
        Object object = null;
        if (httpServletRequest == null) {
            return null;
        }
        String token = httpServletRequest.getHeader(BusinessConstants.ACCESS_TOKEN);
        if (token != null) {
            //开启redis,用户数据放在redis中，从redis中获取
            if (redisTemplate.opsForHash().hasKey(token, key)) {
                //redis中存在，拿出来使用
                object=redisTemplate.opsForHash().get(token, key);
                redisTemplate.expire(token, BusinessConstants.MAX_SESSION_IN_SECONDS, TimeUnit.SECONDS);
            }
        }else {
            throw new BizException("该用户的token不存在");
        }
        return object;
    }
    /**
     * @description: 将信息放进redis或者session中
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/26 10:34
     */
    public void storageObjectBySession(String token,String key,Object object){
        //开启redis,用户数据放进redis中
        redisTemplate.opsForHash().put(token, key,object.toString());
        redisTemplate.expire(token, BusinessConstants.MAX_SESSION_IN_SECONDS, TimeUnit.SECONDS);
    }
    /**
     * @description: 将信息从redis或session中删除
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/26 10:43
     */
    public void deleteObjectBySession(HttpServletRequest httpServletRequest,String key){
        if (httpServletRequest!=null){
            String token = httpServletRequest.getHeader(BusinessConstants.ACCESS_TOKEN);
            if (StringUtil.isNotEmpty(token)){
                //从redis中删除
                redisTemplate.opsForHash().delete(token, key);
            }else {
                throw new BizException("用户登录的token不存在！");
            }
        }
    }
    /**
     * @description: 将信息从redis中删除，对比用户和ip
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/7/26 10:46
     */
    public void deleteObjectByUserAndIp(Long userId,String clientIp){
        Set<String> tokens = redisTemplate.keys("*");
        for (String token : tokens){
            Object userIdValue = redisTemplate.opsForHash().get(token, "userId");
            Object clientIpValue = redisTemplate.opsForHash().get(token, "clientIp");
            if (userIdValue!=null&&clientIpValue!=null&&userIdValue.equals(userId.toString())&&clientIpValue.equals(clientIp)){
                redisTemplate.opsForHash().delete(token, "userId");
            }
        }
    }
    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public Boolean set(String key,Object value,long time){
        try {
            if (time>0){
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }else {
                set(key, value);
            }
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public Boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * @description: 删除redis缓存
     * @param: 可以传一个值 或多个
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/5 17:38
     */
    public void deleteRedisCache(String... key){
        if (key!=null &&key.length>0){
            if (key.length==1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(Arrays.asList(key));
            }
        }
    }

}
