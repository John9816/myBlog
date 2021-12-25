package com.example.myblog.service.article.impl;

import com.example.myblog.model.bo.ArticleBO;
import com.example.myblog.service.article.IArticleReadService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by wangweijie14 on 2021/12/25
 */
@Service
public class ArticleReadServiceImpl implements IArticleReadService {
    @Override
    public List<ArticleBO> queryConsoleArticle(Integer currentPage, Integer perPage) {
        return null;
    }
}
