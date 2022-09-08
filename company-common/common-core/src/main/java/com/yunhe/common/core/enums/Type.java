package com.yunhe.common.core.enums;

public enum Type {
    ALL(0), EXPORT(1), IMPORT(2);
    private final int value;

    Type(int value)
    {
        this.value = value;
    }

    public int value()
    {
        return this.value;
    }
}
