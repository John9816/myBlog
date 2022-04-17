package com.example.myblog.common.utils;

import lombok.Data;

@Data
public class CloudFile {
    private String driveId;

    private String domainId;

    private String fileId;

    private String name;

    private String type;

    private String contentType;

    private String createdAt;

    private String updatedAt;

    private String fileExtension;

    private String mimeType;

    private String mimeExtension;

    private Boolean hidden;

    private Integer size;

    private Boolean starred;

    private String status;

    private String uploadId;

    private String parentFileId;

    private String crc64Hash;

    private String contentHash;

    private String contentHashName;

    private String downloadUrl;

    private String url;

    private String category;

    private String encryptMode;

    private Integer punishFlag;

    private String revisionId;
}
