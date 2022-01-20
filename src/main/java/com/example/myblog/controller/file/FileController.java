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
import javax.servlet.http.HttpServletRequest;


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


//    public static void main(String[] args) {
//        File dir = new File("../../vs");
//        String[] files = dir.list();
//        for (String fileName : files) {
//            // 为目录TestDir下的文件或目录创建File对象
//            File f = new File(dir, fileName);
//            if (f.isFile()) {
//                System.out.println("文件名:"+f.getName());
//                System.out.println("文件绝对路径：" + f.getAbsolutePath());
//                System.out.println("文件路径：" + f.getPath());
//            } else {
//                System.out.println("子目录：" + f);
//            }
//        }
//    }

}