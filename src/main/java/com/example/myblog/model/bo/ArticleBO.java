package com.example.myblog.model.bo;

import lombok.*;


/**
 * created by wangweijie14 on 2021/12/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
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
