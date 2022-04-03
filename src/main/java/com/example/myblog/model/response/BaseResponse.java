package com.example.myblog.model.response;

import com.example.myblog.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 基础响应
 * created by wangweijie14 on 2021/12/25
 */
@Data
@AllArgsConstructor
public class BaseResponse<T> {
    private Status status;
    private T      data;

    public BaseResponse() {
    }

}
