package com.example.myblog.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * 公共BO
 * created by wangweijie14 on 2021/12/25
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Data
public class BaseBO {
    private Long    id;
    private Integer status;
    private Date    createdTime;
    private Date    updatedTime;
}
