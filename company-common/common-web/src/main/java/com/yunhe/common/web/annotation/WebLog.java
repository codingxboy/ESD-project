package com.yunhe.common.web.annotation;

import java.lang.annotation.*;

/**
 * @description: 接口访问日志记录
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/9/16 11:41
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    String description() default "";

}
