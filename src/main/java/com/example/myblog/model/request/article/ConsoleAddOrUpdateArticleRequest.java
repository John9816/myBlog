package com.example.myblog.model.request.article;

import com.example.myblog.model.dto.article.AddOrUpdateArticleConditionDTO;
import com.example.myblog.model.request.BaseRequest;
/**
 * created by wangweijie14 on 2021/12/25
 */
public class ConsoleAddOrUpdateArticleRequest extends BaseRequest {

    private AddOrUpdateArticleConditionDTO condition;

    public AddOrUpdateArticleConditionDTO getArticleDTO() {
        return condition;
    }

    public void setArticleDTO(AddOrUpdateArticleConditionDTO articleDTO) {
        this.condition = articleDTO;
    }

    @Override
    public String toString() {
        return "ConsoleAddOrUpdateArticleRequest{" + "condition=" + condition + '}'+super.toString();
    }
}
