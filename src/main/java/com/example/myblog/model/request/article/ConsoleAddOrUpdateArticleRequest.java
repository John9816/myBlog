package com.example.myblog.model.request.article;

import com.example.myblog.model.dto.article.AddOrUpdateArticleBizRequest;
import com.example.myblog.model.request.BaseRequest;
import lombok.*;

/**
 * created by wangweijie14 on 2021/12/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ConsoleAddOrUpdateArticleRequest extends BaseRequest {

    private AddOrUpdateArticleBizRequest condition;
}
