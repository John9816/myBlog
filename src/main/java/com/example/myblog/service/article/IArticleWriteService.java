package com.example.myblog.service.article;

import com.example.myblog.model.bo.ArticleBO;
import com.example.myblog.model.dto.article.AddOrUpdateArticleConditionDTO;

/**
 * created by wangweijie14 on 2021/12/25
 */
public interface IArticleWriteService {

    void addArticle(AddOrUpdateArticleConditionDTO condition);
}
