package com.yunhe.company.oa.domain.common.aspect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yunhe.common.core.util.IpUtil;
import com.yunhe.company.oa.domain.common.utils.GeoIPUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName WebLogAspect
 * @Description TODO
 * @Author xiaozuqin
 * @Date 2022/9/16 11:51
 * @Version 1.0
 */
@Aspect
@Component
public class WebLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    // 配置织入点
    @Pointcut("@annotation(com.yunhe.common.web.annotation.WebLog)")
//    @Pointcut("execution(public * com.yunhe.company.oa.controller..*.*(..)))")
    public void webLog() {}

    /**
     * 在切点之前织入
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 打印请求相关参数
        logger.info("========================================== Start ==========================================");
        // 打印请求 url
        logger.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
//        logger.info("IP             : {}", request.getRemoteAddr());
        logger.info("IP             : {}", IpUtil.getIpAddr(request));
//        logger.info("IP             : {}", GeoIPUtil.getIpInfo(IpUtil.getIpAddr(request)));
        // 打印请求入参
        logger.info("Request Args   : {}", new GsonBuilder().setPrettyPrinting().create().toJson(joinPoint.getArgs()));
    }


    /**
     * 在切点之后织入
     */
    @After("webLog()")
    public void doAfter() {
        logger.info("=========================================== End ===========================================");
        // 每个请求之间空一行
        logger.info("");
    }
    /**
     * 环绕
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // 打印出参
        logger.info("Response Args  : {}", new Gson().toJson(result));
        // 执行耗时
        logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        return result;
    }


}
