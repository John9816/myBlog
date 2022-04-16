package com.example.myblog.controller.category;

import com.example.myblog.model.response.CommonResponse;
import com.example.myblog.service.category.ICategoryReaderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/channel")
public class CategoryController {

    @Resource
    private ICategoryReaderService categoryReaderService;

    @GetMapping("/list")
    public CommonResponse list(HttpServletRequest request) {
        return null;
    }
}
