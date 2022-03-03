package com.example.myblog.common;

/**
 * created by wangweijie14 on 2021/12/25
 */
public enum BaseErrorCodeEnum implements IError{
    SYSTEM_ERROR(00001, "系统错误"),
    PARAMS_ERROR(00002, "参数错误"),
    FILE_IS_NOT_EXIST(00003, "文件不存在"),
    /*-------------------------文章异常------------------------*/
    ARTICLE_INSERT_ERROR(00004, "新增失败"),
    ARTICLE_UPDATE_ERROR(00005, "更新失败"),
    ;


    private final Integer errorCode;
    private final String errorMsg;

    BaseErrorCodeEnum(Integer errorCode, String errorMsg) {
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
