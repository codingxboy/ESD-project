package com.yunhe.company.erp.common.aspect;
import com.alibaba.fastjson.JSON;
import com.yunhe.common.core.util.IpUtil;
import com.yunhe.common.core.util.UuidUtil;
import com.yunhe.company.erp.common.annotation.OperLog;
import com.yunhe.company.erp.generator.mappers.ExcLogsMapper;
import com.yunhe.company.erp.generator.mappers.OperLogsMapper;
import com.yunhe.company.erp.service.impl.UserServiceImpl;
import com.yunhe.entity.domain.erp.ExcLogsWithBLOBs;
import com.yunhe.entity.domain.erp.OperLogsWithBLOBs;
import com.yunhe.entity.domain.erp.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName OperLogAspect
 * @Description TODO 切面处理类，操作日志异常日志记录处理
 * @Author xiaozuqin
 * @Date 2022/8/16 10:38
 * @Version 1.0
 */
@Aspect
@Component
public class OperLogAspect {

    private Logger logger = LoggerFactory.getLogger(OperLogAspect.class);

    @Value("${nb_erp.version}")
    private String version;
    @Resource
    private OperLogsMapper operLogsMapper;
    @Resource
    private ExcLogsMapper excLogsMapper;
    @Resource
    private UserServiceImpl userServiceImpl;
    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.yunhe.company.erp.common.annotation.OperLog)")
    public void operLogPoincut(){}


    /**
     * 设置异常日志切入点记录异常日志 扫描所有controller包下操作
     */
    @Pointcut("execution(* com.yunhe.company.erp.controller..*.*(..))")
    public void operExceptionLogPoinCut(){}

    @AfterReturning(value = "operLogPoincut()",returning = "keys")
    public void saveOperLog(JoinPoint joinPoint,Object keys){
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest httpServletRequest = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        OperLogsWithBLOBs operLogs = new OperLogsWithBLOBs();
        try {
            operLogs.setOperId(UuidUtil.uuid());
            //从切面连接点通过反射机制获取连接点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            OperLog operLog = method.getAnnotation(OperLog.class);
            if (operLog!=null){
                operLogs.setOperModul(operLog.operModul());
                operLogs.setOperType(operLog.operType());
                operLogs.setOperDesc(operLog.operDesc());
            }
            //获取类名
            String name = joinPoint.getTarget().getClass().getName();
            //获取方法名
            String methodName = method.getName();
            methodName = name + "." + methodName;
            operLogs.setOperMethod(methodName);
            //获取请求的参数
            Map<String, String> map = converMap(httpServletRequest.getParameterMap());
            User userInfoBySession = userServiceImpl.getUserInfoBySession(httpServletRequest);
            //将参数所在的数组转为json
            String params  = JSON.toJSONString(map);
            operLogs.setOperRequParam(params);
            operLogs.setOperRespParam(JSON.toJSONString(keys));
            operLogs.setOperIp(IpUtil.getIpAddr(httpServletRequest));
            operLogs.setOperUri(httpServletRequest.getRequestURI());
            operLogs.setOperVer(version);
            operLogs.setOperCreateTime(new Date());
            operLogs.setOperUserId(String.valueOf(userInfoBySession.getId()));
            operLogs.setOperUserName(userInfoBySession.getUserName());
            operLogsMapper.insert(operLogs);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    /**
     * @description: 异常返回通知，用于拦截异常日志信息 连接点抛出异常后执行
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/16 15:10
     */
    @AfterThrowing(pointcut="operExceptionLogPoinCut()",throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint,Throwable e){
        logger.error("进入异常切入点方法");
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest httpServletRequest = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        ExcLogsWithBLOBs excepLog = new ExcLogsWithBLOBs();
        try {
            excepLog.setExcId(UuidUtil.uuid());
            //从切面连接点通过反射机制获取连接点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            //获取类名
            String name = joinPoint.getTarget().getClass().getName();
            //获取方法名
            String methodName = method.getName();
            methodName = name + "." + methodName;
            excepLog.setOperMethod(methodName);
            //获取请求的参数
            Map<String, String> map = converMap(httpServletRequest.getParameterMap());
            User userInfoBySession = userServiceImpl.getUserInfoBySession(httpServletRequest);
            //将参数所在的数组转为json
            String params  = JSON.toJSONString(map);
            excepLog.setExcRequParam(params);
            excepLog.setOperMethod(methodName);
            excepLog.setExcName(e.getClass().getName());
            excepLog.setExcMessage(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace()));
            excepLog.setOperIp(IpUtil.getIpAddr(httpServletRequest));
            excepLog.setOperUri(httpServletRequest.getRequestURI());
            excepLog.setOperVer(version);
            excepLog.setOperCreateTime(new Date());
            excepLog.setOperUserId(String.valueOf(userInfoBySession.getId()));
            excepLog.setOperUserName(userInfoBySession.getUserName());
            excLogsMapper.insert(excepLog);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @description: 获取请求中的参数
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/16 14:20
     */
    public Map<String,String> converMap(Map<String,String[]> paramMap){
        HashMap<String, String> map = new HashMap<>();
        for (String key:paramMap.keySet()){
            map.put(key, paramMap.get(key)[0]);
        }
        return map;
    }
    /**
     * @description: 转换异常信息为字符串
     * @param:
     * @return:
     * @author xiaozuqin
     * @date: 2022/8/16 15:29
     */
    public String stackTraceToString(String exceptiongName,String exceptiongMessage,StackTraceElement[] elements){
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement:elements){
            stringBuffer.append(stackTraceElement+"\n");
        }
        return exceptiongName+":"+exceptiongMessage+"\n\t"+stringBuffer.toString();
    }



}
