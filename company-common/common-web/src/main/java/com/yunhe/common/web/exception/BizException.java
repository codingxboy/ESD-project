package com.yunhe.common.web.exception;



import com.yunhe.common.core.result.IResultCode;
import lombok.Getter;

@Getter
public class BizException extends RuntimeException {

    public IResultCode resultCode;

    private int code;

    public BizException(IResultCode errorCode) {
        super(errorCode.getMsg());
        this.resultCode = errorCode;
    }

    public BizException(String message){
        super(message);
    }

    public BizException(int code,String message){
        super(message);
        this.code=code;
    }

    public BizException(String message, Throwable cause){
        super(message, cause);
    }

    public BizException(Throwable cause){
        super(cause);
    }
}
