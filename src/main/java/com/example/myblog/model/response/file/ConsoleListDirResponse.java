package com.example.myblog.model.response.file;

import com.example.myblog.common.utils.CloudFile;
import com.example.myblog.model.response.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class ConsoleListDirResponse extends BaseResponse<List<CloudFile>> {
}
