package com.example.myblog.model.request;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;

/**
 * created by wangweijie14 on 2021/12/25
 */
@Data
@ToString
public class BaseRequest {

    private Long id;

    private Date createdTime;

    private Date updatedTime;

    private Boolean isDelete;
}
