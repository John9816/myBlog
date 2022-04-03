/**
 * meituan.com Inc.
 * Copyright (c) 2010-2022 All Rights Reserved.
 */
package com.example.myblog.service.file.impl;

import com.example.myblog.common.exception.BizRuntimeException;
import com.example.myblog.service.file.FileWriteService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static com.example.myblog.common.BaseErrorCodeEnum.FILE_IS_NOT_EXIST;

/**
 * <p>
 *
 * </p>
 * @author wangweijie14
 * @version 1.0:FileWriteServiceImpl.java v1.0 2022/1/17 7:27 下午 wangweijie14 Exp $
 */
@Service
public class FileWriteServiceImpl implements FileWriteService {

    @Override
    public void uploadPicture(MultipartFile file) {
        if (file.isEmpty()) {
            throw new BizRuntimeException(FILE_IS_NOT_EXIST);
        }
        try {
            //文件存放路径
            String path = "/root/blog/file/";
            File targetFile = new File(new File(path).getAbsolutePath());
            // 检测是否存在目录
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            file.transferTo(targetFile);// 文件写入
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
