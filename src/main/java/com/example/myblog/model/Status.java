package com.example.myblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by wangweijie14 on 2021/12/25
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Status {
    private Integer code = 0;
    private String msg = "成功";
    private String failureInfo;
}
