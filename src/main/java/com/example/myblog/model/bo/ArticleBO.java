package com.example.myblog.model.bo;

import lombok.*;
import lombok.experimental.SuperBuilder;


/**
 * created by wangweijie14 on 2021/12/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ArticleBO extends BaseBO{

    private Long userId;
    private Long categoryId;
    private String articleCover;
    private String articleTitle;
    private String articleContent;
    private Integer type;
    private String originalUrl;
    private Integer isTop;
    private Integer isDeleted;
}
