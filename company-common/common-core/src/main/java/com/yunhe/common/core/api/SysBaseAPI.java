package com.yunhe.common.core.api;

/**
 * @ClassName SysBaseAPI
 * @Description TODO 共通业务api,提供给其他模块调用
 * @Author xiaozuqin
 * @Date 2022/7/25 17:24
 * @Version 1.0
 */
public interface SysBaseAPI {
    /**
     * @description:
     * @param: 日志类型（0：操作日志，1：登录日志，2：定时任务
     * @return: 操作类型 1:添加，2：修改，3：删除
     * @author xiaozuqin
     * @date: 2022/7/25 17:27
     */
    void addLog(String LogContent,Integer logType,Integer operatetype);
}
