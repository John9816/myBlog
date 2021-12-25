package com.example.myblog.controller.article;

import com.example.myblog.common.BaseErrorCodeEnum;
import com.example.myblog.common.utils.ParameterCheckUtils;
import com.example.myblog.convert.ArticleBOConvert;
import com.example.myblog.convert.ConsoleArticleDTOConvert;
import com.example.myblog.model.ResponseFactory;
import com.example.myblog.model.bo.ArticleBO;
import com.example.myblog.model.dto.PageDTO;
import com.example.myblog.model.dto.article.AddOrUpdateArticleConditionDTO;
import com.example.myblog.model.dto.article.ConsoleQueryArticleDTO;
import com.example.myblog.model.request.article.ConsoleAddOrUpdateArticleRequest;
import com.example.myblog.model.request.article.ConsoleQueryArticleRequest;
import com.example.myblog.model.response.CommonResponse;
import com.example.myblog.model.response.article.ConsoleArticleDTO;
import com.example.myblog.model.response.article.ConsoleQueryArticleResponse;
import com.example.myblog.service.article.IArticleReadService;
import com.example.myblog.service.article.IArticleWriteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章
 * created by wangweijie14 on 2021/12/25
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private IArticleWriteService articleWriteService;

    @Resource
    private IArticleReadService articleReadService;

    @PostMapping("/add")
    public CommonResponse addArticle(ConsoleAddOrUpdateArticleRequest request) {
        AddOrUpdateArticleConditionDTO condition = request.getArticleDTO();
        //校验合法性
        if (!ParameterCheckUtils.isValidPrimaryKey(condition.getId())) {
            return ResponseFactory.fail(BaseErrorCodeEnum.PARAMS_ERROR, CommonResponse.class);
        }
        ArticleBO articleBO = ArticleBOConvert.toArticleBO(request);
        articleWriteService.addArticle(articleBO);

        return ResponseFactory.success();
    }

    @PostMapping("/save")
    public CommonResponse saveArticle() {


        return ResponseFactory.success();
    }

    @GetMapping("/query")
    public ConsoleQueryArticleResponse queryConsoleArticle(ConsoleQueryArticleRequest request) {
        PageDTO page = request.getPage();
        List<ArticleBO> articleBOList = articleReadService.queryConsoleArticle(page.getCurrentPage(), page.getPerPage());
        List<ConsoleArticleDTO> articleDTOList = ConsoleArticleDTOConvert.toConsoleArticleDTOs(articleBOList);
        ConsoleQueryArticleDTO consoleQueryArticleDTO = new ConsoleQueryArticleDTO();
        consoleQueryArticleDTO.setArticles(articleDTOList);
        return ResponseFactory.success(articleDTOList, ConsoleQueryArticleResponse.class);
    }
}
