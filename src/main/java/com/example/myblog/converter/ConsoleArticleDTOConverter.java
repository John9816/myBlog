package com.example.myblog.converter;

import com.example.myblog.model.bo.ArticleBO;
import com.example.myblog.model.response.article.ConsoleArticleDTO;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class ConsoleArticleDTOConverter {



    public static List<ConsoleArticleDTO> toConsoleArticleDTOs(List<ArticleBO> articleBOs) {
        if (CollectionUtils.isEmpty(articleBOs)) {
            return Collections.emptyList();
        }
        return articleBOs.stream()
                .map(ConsoleArticleDTOConverter::toConsoleArticleDTO)
                .collect(Collectors.toList());
    }


    public static ConsoleArticleDTO toConsoleArticleDTO(ArticleBO article) {
        if (Objects.isNull(article)) {
            return null;
        }
        return ConsoleArticleDTO.builder()
                .id(article.getId())
                .userId(article.getUserId())
                .categoryId(article.getCategoryId())
                .articleCover(article.getArticleCover())
                .articleTitle(article.getArticleTitle())
                .articleContent(article.getArticleContent())
                .type(article.getType())
                .originalUrl(article.getOriginalUrl())
                .status(article.getStatus())
                .isTop(article.getIsTop())
                .isDeleted(article.getIsDeleted())
                .createdTime(article.getCreatedTime().getTime())
                .updatedTime(article.getUpdatedTime().getTime())
                .build();
    }
}
