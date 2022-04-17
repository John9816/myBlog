package com.example.myblog.common.constant;

public class AliYunConstant {
    /**
     * 阿里云接口
     */
    //获取token
    public final static String TOKEN_URL="https://api.aliyundrive.com/token/refresh";
    //文件列表
    public final static String FILE_LIST_URL="https://api.aliyundrive.com/adrive/v3/file/list";
    //文件搜索
    public final static String FILE_SEARCH_URL = "https://api.aliyundrive.com/adrive/v3/file/search";
    //文件上传
    //    public final static String CREATE_FILE_URL="https://api.aliyundrive.com/v2/file/create";
    //文件上传
    public final static String CREATE_FILE_URL="https://api.aliyundrive.com/adrive/v2/file/createWithFolders";
    //完成上传
    public final static String COMPLETE_FILE_URL="https://api.aliyundrive.com/v2/file/complete";
    //删除文件
    public final static String DELETE_FILE_URL="https://api.aliyundrive.com/v2/recyclebin/trash";
    //下载文件
    public final static String DOWNLOAD_FILE_URL="https://api.aliyundrive.com/v2/file/get_download_url";
    //目录层级
    public final static String FOLDER_PATH_URL = "https://api.aliyundrive.com/adrive/v1/file/get_path";
    //修改目录
    public final static String UPDATE_FOLDER_URL = "https://api.aliyundrive.com/v3/file/update";
    //Token
    public static String TOKEN="";
    //access_token
    public static String ACCESS_TOKEN="";
    //driveId
    public static String DriveId="1992560";
    //根目录
    public final static String ROOT="root";
    //登录状态
    public static boolean LOGIN_STATUS = false;

    //默认大小
    public static final Integer DEFAULT_SIZE = 10480000;
}
