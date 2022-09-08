package com.yunhe.company.erp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunhe.common.core.util.ToolsUtil;
import com.yunhe.company.erp.common.redis.RedisService;

import com.yunhe.company.erp.generator.mappers.LogMapper;
import com.yunhe.company.erp.generator.mappers.LogMapperEx;
import com.yunhe.company.erp.service.LogService;
import com.yunhe.entity.domain.erp.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @ClassName LogServiceImpl
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/7/26 16:29
 * @Version 1.0
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    private Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Resource
    private LogMapperEx logMapperEx;
    @Resource
    private LogMapper logMapper;
    @Resource
    private UserServiceImpl userServiceImpl;
    @Resource
    private RedisService redisService;

    @Override
    public void insertLogWithUserId(Long userId, String moduleName, String content, HttpServletRequest request) {
        try {
            if (userId!=null){
                Log log = new Log();
                log.setUserId(userId);
                log.setOperation(moduleName);
                log.setClientIp(ToolsUtil.getLocalIp(request));
                log.setCreateTime(new Date());
                log.setUpdateTime(new Date());
                Byte status=0;
                log.setStatus(status);
                log.setContent(content);
                logMapperEx.insertLogWithUserId(log);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("数据写入异常", exception);
        }
    }

    @Override
    public void insertLog(String moduleName, String content, HttpServletRequest request) {
        try {
            Long userId = userServiceImpl.getUserId(request);
            if (userId!=null){
                String clientIp = ToolsUtil.getLocalIp(request);
                String createTime = ToolsUtil.getNow3();
                Long countByIpAndDate = logMapperEx.getCountByIpAndDate(userId, moduleName, clientIp, createTime);
                if (countByIpAndDate>0){
                    redisService.deleteObjectByUserAndIp(userId,clientIp);
                }else {
                    Log log = new Log();
                    log.setUserId(userId);
                    log.setClientIp(clientIp);
                    log.setContent(content);
                    log.setCreateTime(new Date());
                    log.setUpdateTime(new Date());
                    log.setOperation(moduleName);
                    Byte status=0;
                    log.setStatus(status);
                    logMapper.insertSelective(log);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            logger.error("用户操作日志写入异常", exception);
        }
    }
}
