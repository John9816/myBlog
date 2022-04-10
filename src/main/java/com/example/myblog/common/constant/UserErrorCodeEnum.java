package com.example.myblog.common.constant;

import com.example.myblog.common.IError;

public enum UserErrorCodeEnum implements IError {
    //3000-4000
    ACCOUNT_OR_PASSWORD_INVALID(3000,"账号或密码错误");

    private final Integer errorCode;
    private final String  errorMsg;

    UserErrorCodeEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public int getCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }
}
