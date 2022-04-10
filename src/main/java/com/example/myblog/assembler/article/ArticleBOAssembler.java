package com.example.myblog.assembler.article;

import com.example.myblog.model.bo.ArticleBO;
import com.example.myblog.model.dao.ArticleDO;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class ArticleBOAssembler {

    public static List<ArticleBO> toArticleBOs(List<ArticleDO> articleDOs) {
        if (CollectionUtils.isEmpty(articleDOs)) {
            return Collections.emptyList();
        }
        return articleDOs.stream()
                .map(ArticleBOAssembler::toArticleBO)
                .collect(Collectors.toList());
    }


    public static ArticleBO toArticleBO(ArticleDO articleDO) {
        if (Objects.isNull(articleDO)) {
            return null;
        }
        return ArticleBO.childBuilder()
                .id(articleDO.getId())
                .userId(articleDO.getUserId())
                .categoryId(articleDO.getCategoryId())
                .articleCover(articleDO.getArticleCover())
                .articleTitle(articleDO.getArticleTitle())
                .articleContent(articleDO.getArticleContent())
                .type(articleDO.getType())
                .originalUrl(articleDO.getOriginalUrl())
                .status(articleDO.getStatus())
                .isTop(articleDO.getIsTop())
                .isDeleted(articleDO.getIsDeleted())
                .createdTime(articleDO.getCreatedTime())
                .updatedTime(articleDO.getUpdatedTime())
                .build();
    }
}
