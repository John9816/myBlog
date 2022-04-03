package com.example.myblog.model.bo;

import lombok.*;

import java.util.Date;

/**
 * 公共BO
 * created by wangweijie14 on 2021/12/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseBO {
    private Long    id;
    private Date    createdTime;
    private Date    updatedTime;
}
