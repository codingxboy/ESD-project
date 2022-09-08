package com.yunhe.common.core.enums;

public enum ColumnType {
    NUMERIC(0), STRING(1);
    private final int value;

    ColumnType(int value)
    {
        this.value = value;
    }

    public int value()
    {
        return this.value;
    }
}
