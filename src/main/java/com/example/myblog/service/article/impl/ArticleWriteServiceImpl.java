package com.example.myblog.service.article.impl;


import com.example.myblog.convert.AddOrUpdateArticleConditionDTOConvert;
import com.example.myblog.mapper.ArticleMapper;
import com.example.myblog.model.dto.article.AddOrUpdateArticleConditionDTO;
import com.example.myblog.service.article.IArticleWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * created by wangweijie14 on 2021/12/25
 */
@Service
public class ArticleWriteServiceImpl implements IArticleWriteService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public void addArticle(AddOrUpdateArticleConditionDTO condition) {

        if (Objects.isNull(condition)) {
            return;
        }
        articleMapper.add(AddOrUpdateArticleConditionDTOConvert.toArticleDO(condition));

    }
}
