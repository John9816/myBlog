package com.example.myblog.model.dto.article;


import com.example.myblog.model.dto.BaseDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * created by wangweijie14 on 2021/12/20
 */

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class AddOrUpdateArticleConditionDTO extends BaseDTO {
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