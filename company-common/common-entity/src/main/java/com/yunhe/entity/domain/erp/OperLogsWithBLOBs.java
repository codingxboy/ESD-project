package com.yunhe.entity.domain.erp;

public class OperLogsWithBLOBs extends OperLogs {
    private String operRequParam;

    private String operRespParam;

    @Override
    public String getOperRequParam() {
        return operRequParam;
    }

    @Override
    public void setOperRequParam(String operRequParam) {
        this.operRequParam = operRequParam == null ? null : operRequParam.trim();
    }

    @Override
    public String getOperRespParam() {
        return operRespParam;
    }

    @Override
    public void setOperRespParam(String operRespParam) {
        this.operRespParam = operRespParam == null ? null : operRespParam.trim();
    }
}
