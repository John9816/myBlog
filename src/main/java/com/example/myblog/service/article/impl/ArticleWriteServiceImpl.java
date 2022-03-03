package com.example.myblog.service.article.impl;


import com.example.myblog.common.BaseErrorCodeEnum;
import com.example.myblog.convert.AddOrUpdateArticleConditionDTOConvert;
import com.example.myblog.exception.BizRuntimeException;
import com.example.myblog.mapper.ArticleMapper;
import com.example.myblog.model.dto.article.AddOrUpdateArticleConditionDTO;
import com.example.myblog.service.article.IArticleWriteService;
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
        boolean success = articleMapper.add(AddOrUpdateArticleConditionDTOConvert.toArticleDO(condition)) == 1;
        if (!success) {
            throw new BizRuntimeException(BaseErrorCodeEnum.ARTICLE_INSERT_ERROR);
        }
    }

    @Override
    public void updateArticle(AddOrUpdateArticleConditionDTO condition) {
        if (Objects.isNull(condition)) {
            return;
        }
        boolean success = articleMapper.update(AddOrUpdateArticleConditionDTOConvert.toArticleDO(condition)) == 1;
        if (!success) {
            throw new BizRuntimeException(BaseErrorCodeEnum.ARTICLE_INSERT_ERROR);
        }
    }
}
