package com.example.myblog.service.file;

import com.example.myblog.common.utils.CloudFile;

import java.util.List;

public interface IFileReadService {
    List<CloudFile> listDir(String fileId);

}
