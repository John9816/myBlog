package com.example.myblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by wangweijie14 on 2021/12/20
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseDTO {
    private Long id;
    private Long createdTime;
    private Long updatedTime;
}
