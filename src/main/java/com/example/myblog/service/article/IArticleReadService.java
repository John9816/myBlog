package com.example.myblog.service.article;

import com.example.myblog.model.bo.ArticleBO;

import java.util.List;

/**
 * 文章读接口
 * created by wangweijie14 on 2021/12/25
 */
public interface IArticleReadService {
    /**
     * 查询文章列表
     * @param currentPage 当前页面
     * @param perPage 页大小
     * @return 文章列表
     */
    List<ArticleBO> queryConsoleArticle(Integer currentPage, Integer perPage);

    /**
     * 根据id查询文章
     * @param id 文章id
     * @return 文章
     */
    ArticleBO getById(Long id);
}
