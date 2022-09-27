package com.yunhe.company.oa.domain.common.annotation;

import java.lang.annotation.*;

/**
 * @description: 自定义注解把重要接口请求日志持久化到数据库
 * @param:
 * @return:
 * @author xiaozuqin
 * @date: 2022/9/16 10:52
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface annotation {


}
