package com.example.myblog.service.article.impl;

import com.example.myblog.assembler.article.ArticleBOAssembler;
import com.example.myblog.mapper.ArticleMapper;
import com.example.myblog.model.bo.ArticleBO;
import com.example.myblog.model.dao.ArticleDO;
import com.example.myblog.service.article.IArticleReadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by wangweijie14 on 2021/12/25
 */
@Service
public class ArticleReadServiceImpl implements IArticleReadService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleBO> queryConsoleArticle(Integer currentPage, Integer perPage) {
        List<ArticleDO> articleDOList = articleMapper.listAll(currentPage, perPage);
        return ArticleBOAssembler.toArticleBOs(articleDOList);
    }

    @Override
    public ArticleBO getById(Long id) {
        ArticleDO articleDO = articleMapper.listById(id);
        return ArticleBOAssembler.toArticleBO(articleDO);
    }
}
