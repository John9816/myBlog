package com.example.myblog.model.dto.article;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * created by wangweijie14 on 2021/12/20
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddOrUpdateArticleConditionDTO {

    @Positive
    private Long id;
    private Integer status;
    private Long createdTime;
    private Long updatedTime;
    @Positive
    private Long userId;
    @Positive
    private Long categoryId;
    private String articleCover;
    @NotBlank
    private String articleTitle;
    @NotBlank
    private String articleContent;
    private Integer type;
    private String originalUrl;
    private Integer isTop;
    private Integer isDeleted;
}
