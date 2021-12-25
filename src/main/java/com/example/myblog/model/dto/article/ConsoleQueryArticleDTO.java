package com.example.myblog.model.dto.article;

import com.example.myblog.model.dto.PageDTO;
import com.example.myblog.model.response.article.ConsoleArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * created by wangweijie14 on 2021/12/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsoleQueryArticleDTO {

    private PageDTO page;

    private List<ConsoleArticleDTO> articles;

}
