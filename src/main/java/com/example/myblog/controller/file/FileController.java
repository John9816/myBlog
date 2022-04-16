/**
 * meituan.com Inc.
 * Copyright (c) 2010-2022 All Rights Reserved.
 */
package com.example.myblog.controller.file;

import com.example.myblog.common.ResponseFactory;
import com.example.myblog.model.response.CommonResponse;
import com.example.myblog.service.file.FileWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;
import xyz.xuminghai.pojo.response.file.ListResponse;
import xyz.xuminghai.template.BlockClientTemplate;
import xyz.xuminghai.template.ReactiveClientTemplate;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 * @author wangweijie14
 * @version 1.0:FileController.java v1.0 2022/1/17 2:44 下午 wangweijie14 Exp $
 */
@RestController
@RequestMapping("/upload")
public class FileController {

    @Resource
    private FileWriteService fileWriteService;

    @Resource
    private ReactiveClientTemplate reactiveClientTemplate;

    @Resource
    private BlockClientTemplate blockClientTemplate;


    @GetMapping("/file")
    @ResponseBody
    public CommonResponse uploadPicture() {
//        fileWriteService.uploadPicture(file);
        Mono<ResponseEntity<ListResponse>> list = reactiveClientTemplate.list();

        System.out.println(list);
        return ResponseFactory.success();
    }

}