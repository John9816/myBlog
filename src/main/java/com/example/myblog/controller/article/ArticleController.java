package com.example.myblog.controller.article;

import com.example.myblog.common.BaseErrorCodeEnum;
import com.example.myblog.common.utils.ParameterCheckUtils;
import com.example.myblog.common.ResponseFactory;
import com.example.myblog.converter.ConsoleArticleDTOConverter;
import com.example.myblog.model.bo.ArticleBO;
import com.example.myblog.model.dto.PageDTO;
import com.example.myblog.model.dto.article.AddOrUpdateArticleBizRequest;
import com.example.myblog.model.dto.article.ConsoleQueryArticleDTO;
import com.example.myblog.model.request.article.ConsoleAddOrUpdateArticleRequest;
import com.example.myblog.model.request.article.ConsoleQueryArticleRequest;
import com.example.myblog.model.response.CommonResponse;
import com.example.myblog.model.response.article.ConsoleArticleDTO;
import com.example.myblog.model.response.article.ConsoleListArticleResponse;
import com.example.myblog.model.response.article.ConsoleQueryArticleResponse;
import com.example.myblog.service.article.IArticleReadService;
import com.example.myblog.service.article.IArticleWriteService;
import org.springframework.web.bind.annotation.*;

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
        AddOrUpdateArticleBizRequest bizRequest = request.getCondition();
        //校验合法性
        if (!ParameterCheckUtils.isValidPrimaryKey(bizRequest.getId())) {
            return ResponseFactory.fail(BaseErrorCodeEnum.PARAMS_ERROR, CommonResponse.class);
        }
        articleWriteService.addArticle(bizRequest);
        return ResponseFactory.success();
    }

    @PostMapping("/update")
    public CommonResponse updateArticle(ConsoleAddOrUpdateArticleRequest request) {
        AddOrUpdateArticleBizRequest bizRequest = request.getCondition();
        //校验合法性
        if (!ParameterCheckUtils.isValidPrimaryKey(bizRequest.getId())) {
            return ResponseFactory.fail(BaseErrorCodeEnum.PARAMS_ERROR, CommonResponse.class);
        }
        articleWriteService.updateArticle(bizRequest);
        return ResponseFactory.success();
    }

    @GetMapping("/getById")
    public ConsoleListArticleResponse getById(Long id) {
        //校验合法性
        if (!ParameterCheckUtils.isValidPrimaryKey(id)) {
            return ResponseFactory.fail(BaseErrorCodeEnum.PARAMS_ERROR, ConsoleListArticleResponse.class);
        }
        ArticleBO articleBO = articleReadService.getById(id);
        return ResponseFactory
                .success(ConsoleArticleDTOConverter.toConsoleArticleDTO(articleBO), ConsoleListArticleResponse.class);
    }


    @PostMapping("/query")
    public ConsoleQueryArticleResponse queryConsoleArticle(@RequestBody ConsoleQueryArticleRequest request) {
        PageDTO page = request.getPage();
        List<ArticleBO> articleBOs = articleReadService.queryConsoleArticle(page.getCurrentPage(), page.getPrePage());
        List<ConsoleArticleDTO> consoleArticleDTOs = ConsoleArticleDTOConverter.toConsoleArticleDTOs(articleBOs);

        ConsoleQueryArticleDTO consoleQueryArticleDTO = new ConsoleQueryArticleDTO();
        page.setTotal(consoleArticleDTOs.size());
        consoleQueryArticleDTO.setArticles(consoleArticleDTOs);
        consoleQueryArticleDTO.setPage(page);
        return ResponseFactory.success(consoleQueryArticleDTO, ConsoleQueryArticleResponse.class);
    }

    @PostMapping("delete")
    public CommonResponse deleteById(Long id) {
        //校验合法性
        if (!ParameterCheckUtils.isValidPrimaryKey(id)) {
            return ResponseFactory.fail(BaseErrorCodeEnum.PARAMS_ERROR, CommonResponse.class);
        }
        articleWriteService.deleteById(id);
        return ResponseFactory.success();
    }
    @GetMapping("/test")
    public void test() {
        System.out.println(23231);
    }

}
