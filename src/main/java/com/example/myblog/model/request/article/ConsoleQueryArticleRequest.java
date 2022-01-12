package com.example.myblog.model.request.article;

import com.example.myblog.model.dto.PageDTO;
import com.example.myblog.model.request.BaseRequest;

import javax.validation.Valid;

/**
 * created by wangweijie14 on 2021/12/25
 */
public class ConsoleQueryArticleRequest extends BaseRequest {

    @Valid
    private PageDTO page;

    public PageDTO getPage() {
        return page;
    }

    public void setPage(PageDTO page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "ConsoleQueryArticleRequest{" + "page=" + page + '}';
    }
}
