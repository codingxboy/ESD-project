package com.yunhe.company.erp.common.annotation;

import java.lang.annotation.*;

/**
 * @description: 自定义操作日志注解
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/8/16 10:35
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperLog {

    String operModul() default ""; // 操作模块
    String operType() default "";  // 操作类型
    String operDesc() default "";  // 操作说明
}
