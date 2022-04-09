package com.example.myblog.model.bo;

import lombok.*;

import java.util.Date;

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
    private Integer status;
    private Integer isTop;
    private Integer isDeleted;

    @Builder(builderMethodName = "childBuilder")
    public ArticleBO(Long id, Date createdTime, Date updatedTime, Long userId, Long categoryId, String articleCover, String articleTitle,
                     String articleContent, Integer type, String originalUrl, Integer status, Integer isTop, Integer isDeleted) {
        super(id, createdTime, updatedTime);
        this.userId = userId;
        this.categoryId = categoryId;
        this.articleCover = articleCover;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.type = type;
        this.originalUrl = originalUrl;
        this.status = status;
        this.isTop = isTop;
        this.isDeleted = isDeleted;
    }
}
