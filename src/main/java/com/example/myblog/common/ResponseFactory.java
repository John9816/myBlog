package com.example.myblog.common;

import com.example.myblog.common.constant.MethodNameConstant;
import com.example.myblog.common.utils.MethodCacheManager;
import com.example.myblog.common.exception.BizRuntimeException;
import com.example.myblog.model.Status;
import com.example.myblog.model.response.CommonResponse;

import java.lang.reflect.Method;

/**
 * created by wangweijie14 on 2021/12/25
 */
public class ResponseFactory {
    public ResponseFactory() {

    }

    /**
     * 构造一个成功得响应请求
     * @return 响应结果
     */
    public static CommonResponse success() {
        CommonResponse response = new CommonResponse();
        response.setStatus(new Status());
        return response;
    }

    public static <T> T fail(IError error, Class<T> clazz) {
        return fail(error.getCode(), error.getMessage(), null, clazz);
    }

    public static <T> T fail(Integer errorCode, String errorMsg, String failureInfo, Class<T> clazz) {
        Method setStatus = MethodCacheManager.fetchMethod(clazz, MethodNameConstant.SET_STATUS);
        if (setStatus == null) {
            throw new BizRuntimeException(BaseErrorCodeEnum.SYSTEM_ERROR);
        }

        T obj = null;
        try {
            obj = clazz.newInstance();
            Class<?> paramsClazz = setStatus.getParameterTypes()[0];
            if (Status.class.equals(paramsClazz)) {
                Status status = new Status();
                status.setCode(errorCode);
                status.setMsg(errorMsg);
                setStatus.invoke(obj, status);
            } else {
                setStatus.invoke(obj, new Status(errorCode, errorMsg, failureInfo));
            }

        } catch (Exception e) {
            throw new BizRuntimeException(BaseErrorCodeEnum.SYSTEM_ERROR, e);
        }
       return obj;
    }

    public static <T1, T2> T2 success(T1 data, Class<T2> clazz) {
        if (clazz == null) {
            throw new BizRuntimeException(BaseErrorCodeEnum.SYSTEM_ERROR);
        }
        Method setStatus = MethodCacheManager.fetchMethod(clazz, MethodNameConstant.SET_STATUS);
        Method setData = MethodCacheManager.fetchMethod(clazz, MethodNameConstant.SET_DATA);
        if (setData == null || setStatus == null) {
            throw new BizRuntimeException(BaseErrorCodeEnum.SYSTEM_ERROR);
        }

        T2 obj = null;
        try {
            obj = clazz.newInstance();
            Class<?> paramsClazz = setStatus.getParameterTypes()[0];
            if (Status.class.equals(paramsClazz)) {
                setStatus.invoke(obj, new Status());
            } else {
                setStatus.invoke(obj, data);
            }
            setData.invoke(obj, data);
            return obj;
        } catch (Exception e) {
            throw new BizRuntimeException(BaseErrorCodeEnum.SYSTEM_ERROR, e);
        }

    }
}
