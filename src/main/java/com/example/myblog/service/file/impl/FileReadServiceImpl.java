package com.example.myblog.service.file.impl;

import com.example.myblog.common.utils.AliYunUtil;
import com.example.myblog.common.utils.CloudFile;
import com.example.myblog.service.file.IFileReadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileReadServiceImpl implements IFileReadService {
    static {
        AliYunUtil.login();
    }

    @Override
    public List<CloudFile> listDir(String fileId) {

        return AliYunUtil.getCloudFileList(fileId);
    }
}
