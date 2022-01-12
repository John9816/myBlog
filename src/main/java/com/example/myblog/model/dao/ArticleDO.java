package com.example.myblog.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by wangweijie14 on 2021/12/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDO {

    private Long    id;
    private Long userId;
    private Long categoryId;
    private String articleCover;
    private String articleTitle;
    private String articleContent;
    private Integer type;
    private String originalUrl;
    private Integer isTop;
    private Integer isDeleted;
    private  Integer status;
    private  Date    createdTime;
    private  Date    updatedTime;
}
