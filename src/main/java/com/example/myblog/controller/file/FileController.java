/**
 * meituan.com Inc.
 * Copyright (c) 2010-2022 All Rights Reserved.
 */
package com.example.myblog.controller.file;

import com.example.myblog.common.ResponseFactory;
import com.example.myblog.common.utils.CloudFile;
import com.example.myblog.model.request.file.ConsoleListDirRequest;
import com.example.myblog.model.response.CommonResponse;
import com.example.myblog.model.response.file.ConsoleListDirResponse;
import com.example.myblog.service.file.IFileReadService;
import com.example.myblog.service.file.IFileWriteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 * @author wangweijie14
 * @version 1.0:FileController.java v1.0 2022/1/17 2:44 下午 wangweijie14 Exp $
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private IFileWriteService fileWriteService;

    @Resource
    private IFileReadService fileReaderService;

    @PostMapping("/list")
    @ResponseBody
    public ConsoleListDirResponse listDir(@RequestBody ConsoleListDirRequest request) {
        List<CloudFile> cloudFiles = fileReaderService.listDir(request.getFileId());
        return ResponseFactory.success(cloudFiles, ConsoleListDirResponse.class);
    }
}
