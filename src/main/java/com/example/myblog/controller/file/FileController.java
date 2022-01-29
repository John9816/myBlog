/**
 * meituan.com Inc.
 * Copyright (c) 2010-2022 All Rights Reserved.
 */
package com.example.myblog.controller.file;

import com.example.myblog.model.ResponseFactory;
import com.example.myblog.model.response.CommonResponse;
import com.example.myblog.service.file.FileWriteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @PostMapping("/file")
    @ResponseBody
    public CommonResponse uploadPicture(@RequestParam("file") MultipartFile file) {
        fileWriteService.uploadPicture(file);
        return ResponseFactory.success();
    }

}