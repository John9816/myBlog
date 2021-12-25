package com.example.myblog.convert;

import com.example.myblog.model.bo.ArticleBO;
import com.example.myblog.model.response.article.ConsoleArticleDTO;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * created by wangweijie14 on 2021/12/25
 */
public final class ConsoleArticleDTOConvert {
    public static List<ConsoleArticleDTO> toConsoleArticleDTOs(List<ArticleBO> articleBOList) {
        if (CollectionUtils.isEmpty(articleBOList)) {
            return Collections.emptyList();
        }
        return null;
    }
}
