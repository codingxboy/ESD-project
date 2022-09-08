package com.yunhe.company.erp.service;

import javax.servlet.http.HttpServletRequest;

public interface LogService {

    void insertLogWithUserId(Long userId, String moduleName, String content, HttpServletRequest request);

    void insertLog(String moduleName, String content, HttpServletRequest request);
}
