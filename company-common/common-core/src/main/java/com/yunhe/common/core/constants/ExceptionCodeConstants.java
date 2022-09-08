package com.yunhe.common.core.constants;

/**
 * @ClassName ExceptionCodeConstants
 * @Description TODO 用户错误码定义
 * @Author xiaozuqin
 * @Date 2022/7/26 11:40
 * @Version 1.0
 */
public class ExceptionCodeConstants {
    /**
     * 用户不存在
     */
    public static final int USER_NOT_EXIST = 1;

    /**
     * 用户名或密码错误
     */
    public static final int USER_PASSWORD_ERROR = 2;

    /**
     * 用户被加入黑名单
     */
    public static final int BLACK_USER = 3;

    /**
     * 可以登录
     */
    public static final int USER_CONDITION_FIT = 4;


    /**
     * 访问数据库异常
     */
    public static final int USER_ACCESS_EXCEPTION = 5;

    /**
     * 用户已经登录
     */
    public static final int USER_ALREADY_LOGIN = 6;

    /**
     * 用户访问服务异常
     */
    public static final int ACCESS_SERVICE_EXCEPTION = 7;

}
