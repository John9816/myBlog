package com.example.myblog.convert;

import com.example.myblog.model.bo.ArticleBO;
import com.example.myblog.model.dto.article.AddOrUpdateArticleConditionDTO;
import com.example.myblog.model.request.article.ConsoleAddOrUpdateArticleRequest;

import java.util.Objects;

/**
 * created by wangweijie14 on 2021/12/25
 */
public final class ArticleBOConvert {
    public static ArticleBO toArticleBO(ConsoleAddOrUpdateArticleRequest request) {
        if (Objects.isNull(request)) {
            return null;
        }

        AddOrUpdateArticleConditionDTO condition = request.getArticleDTO();
        return ArticleBO.builder()
                .id(condition.getId())
                .userId(condition.getUserId())
                .categoryId(condition.getCategoryId())
                .articleTitle(condition.getArticleTitle())
                .articleCover(condition.getArticleCover())
                .articleContent(condition.getArticleContent())
                .type(condition.getType())
                .originalUrl(condition.getOriginalUrl())
                .isTop(1)
                .isDeleted(0)
                .build();
    }
}
