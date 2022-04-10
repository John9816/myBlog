package com.example.myblog.converter;

import com.example.myblog.model.dao.ArticleDO;
import com.example.myblog.model.dto.article.AddOrUpdateArticleBizRequest;

import java.util.Date;
import java.util.Objects;

/**
 * created by wangweijie14 on 2022/1/12
 */
public final class AddOrUpdateArticleConditionDTOConverter {

    public AddOrUpdateArticleConditionDTOConverter() {

    }

    public static ArticleDO toArticleDO(AddOrUpdateArticleBizRequest condition) {
        if (Objects.isNull(condition)) {
            return null;
        }
        return ArticleDO.builder()
                .id(condition.getId())
                .userId(condition.getUserId())
                .categoryId(condition.getCategoryId())
                .articleCover(condition.getArticleCover())
                .articleTitle(condition.getArticleTitle())
                .articleContent(condition.getArticleContent())
                .type(condition.getType())
                .originalUrl(condition.getOriginalUrl())
                .isTop(condition.getIsTop())
                .isDeleted(condition.getIsDeleted())
                .createdTime(new Date(condition.getCreatedTime()))
                .updatedTime(new Date(condition.getUpdatedTime()))
                .build();
    }
}
