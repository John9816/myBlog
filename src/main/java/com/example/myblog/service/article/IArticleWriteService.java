package com.example.myblog.service.article;

import com.example.myblog.model.dto.article.AddOrUpdateArticleBizRequest;

/**
 * created by wangweijie14 on 2021/12/25
 */
public interface IArticleWriteService {

    void addArticle(AddOrUpdateArticleBizRequest condition);

    void updateArticle(AddOrUpdateArticleBizRequest condition);

    void deleteById(Long id);
}
