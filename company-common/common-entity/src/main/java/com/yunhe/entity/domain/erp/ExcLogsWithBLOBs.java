package com.yunhe.entity.domain.erp;

public class ExcLogsWithBLOBs extends ExcLogs {
    private String excRequParam;

    private String excMessage;

    public String getExcRequParam() {
        return excRequParam;
    }

    public void setExcRequParam(String excRequParam) {
        this.excRequParam = excRequParam == null ? null : excRequParam.trim();
    }

    public String getExcMessage() {
        return excMessage;
    }

    public void setExcMessage(String excMessage) {
        this.excMessage = excMessage == null ? null : excMessage.trim();
    }
}
