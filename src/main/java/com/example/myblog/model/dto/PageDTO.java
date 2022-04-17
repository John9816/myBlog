package com.example.myblog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 页签
 * created by wangweijie14 on 2021/12/25
 */
@Data
@AllArgsConstructor
@Builder
public class PageDTO {

    @NotNull(message = "当前页为必传项")
    @Min(value = 1L, message = "当前页最小为1")
    @Max(value = 2000L, message = "当前页最大为2000")
    private Integer currentPage;

    @NotNull(message = "页大小为必传项")
    @Min(value = 1L, message = "页大小最小为1")
    @Max(value = 2000L, message = "页大小最大为2000")
    private Integer prePage;

    private Integer total;

}
