package com.example.myblog.common.constant;

import java.util.HashMap;
import java.util.Map;

import static com.example.myblog.common.constant.AliYunConstant.*;

public class DictConstants {
    //文件
    public static final String FILE_TYPE_FILE = "file";
    //文件夹
    public static final String FILE_TYPE_FOLDER = "folder";

    /**
     * 备份模式
     */
    public static Map<Integer, String> BACKUP_TYPE_DICT     = new HashMap<>();
    //普通备份
    public static Integer              BACKUP_TYPE_ORDINARY = 0;
    //分类备份
    public static Integer BACKUP_TYPE_CLASSIFY = 1;
    //微信备份
    public static Integer BACKUP_TYPE_WECHAT = 2;

    /**
     * 开启 关闭
     */
    public static Map<Integer, String> ON_OFF_DICT = new HashMap<>();
    //开启目录检测
    public static Integer ON = 0;
    //关闭目录检测
    public static Integer OFF = 1;

    /**
     * 备份任务状态
     */
    public static Map<Integer, String> STATUS_DICT = new HashMap<>();
    //备份任务正常
    public static Integer STATUS_ENABLE = 0;
    //备份任务禁用
    public static Integer STATUS_DISABLE = 1;
    //备份任务运行中
    public static Integer STATUS_BACKUP_RUN = 2;
    //同步任务运行中
    public static Integer STATUS_SYNC_RUN = 3;

    /**
     * 接口名称
     */
    public static Map<String, String> URI_DICT = new HashMap<>();

    static {
        BACKUP_TYPE_DICT.put(BACKUP_TYPE_ORDINARY,"普通备份");
        BACKUP_TYPE_DICT.put(BACKUP_TYPE_CLASSIFY,"分类备份");
        BACKUP_TYPE_DICT.put(BACKUP_TYPE_WECHAT,"微信备份");

        ON_OFF_DICT.put(ON,"开启");
        ON_OFF_DICT.put(OFF,"关闭");

        STATUS_DICT.put(STATUS_ENABLE,"正常");
        STATUS_DICT.put(STATUS_DISABLE,"已禁用");
        STATUS_DICT.put(STATUS_BACKUP_RUN,"备份中");
        STATUS_DICT.put(STATUS_SYNC_RUN,"同步中");


        URI_DICT.put(TOKEN_URL,"获取Token");
        URI_DICT.put(FILE_LIST_URL,"文件列表");
        URI_DICT.put(FILE_SEARCH_URL,"文件搜索");
        URI_DICT.put(CREATE_FILE_URL,"文件上传");
        URI_DICT.put(COMPLETE_FILE_URL,"完成上传");
        URI_DICT.put(DELETE_FILE_URL,"删除文件");
        URI_DICT.put(DOWNLOAD_FILE_URL,"文件下载");
        URI_DICT.put(FOLDER_PATH_URL,"目录层级");
        URI_DICT.put(UPDATE_FOLDER_URL,"修改目录");
    }
}
