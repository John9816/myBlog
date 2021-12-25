package com.example.myblog.service.article;

import com.example.myblog.model.bo.ArticleBO;

import java.util.List;

/**
 * created by wangweijie14 on 2021/12/25
 */
public interface IArticleReadService {
    List<ArticleBO> queryConsoleArticle(Integer currentPage, Integer perPage);

}
