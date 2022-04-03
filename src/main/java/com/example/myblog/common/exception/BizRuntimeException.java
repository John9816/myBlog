package com.example.myblog.common.exception;

import com.example.myblog.common.IError;

/**
 * created by wangweijie14 on 2021/12/25
 */
public class BizRuntimeException extends RuntimeException{
    private IError errorCode;

    public BizRuntimeException(IError errorCode) {
        this.errorCode = errorCode;
    }
    public BizRuntimeException(IError errorCode, Throwable causes) {
        super(causes.toString());
        this.setErrorCode(errorCode);
    }

    public IError getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(IError errorCode) {
        this.errorCode = errorCode;
    }
}
