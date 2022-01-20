/**
 * meituan.com Inc.
 * Copyright (c) 2010-2022 All Rights Reserved.
 */
package com.example.myblog.service.file;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *
 * </p>
 * @author wangweijie14
 * @version 1.0:FileWriteService.java v1.0 2022/1/17 7:26 下午 wangweijie14 Exp $
 */
public interface FileWriteService {

    void uploadPicture(MultipartFile file);
}