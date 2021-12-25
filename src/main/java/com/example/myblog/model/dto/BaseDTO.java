package com.example.myblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * created by wangweijie14 on 2021/12/20
 */
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Data
public class BaseDTO {
    private Long id;
    private Integer status;
    private Long createdTime;
    private Long updatedTime;
}
