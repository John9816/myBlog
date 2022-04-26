package com.example.myblog.common.utils;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Objects;

import static com.example.myblog.common.constant.AliYunConstant.*;

public class AliYunUtil {

    @Value("${alipan.refresh_token}")
    private static String refresh_token;

    /**
     * 获取阿里云信息
     * @return 登录状态
     */
    public static boolean login() {
        String token = refresh_token;
        if (StringUtils.isEmpty(token)) {
            return false;
        }
        JSONObject data = new JSONObject().set("refresh_token", token);
        JSONObject result = OkhttpUtil.doPost(TOKEN_URL, data);
        if (Objects.isNull(result) || "InvalidParameter.RefreshToken".equals(result.getStr("code"))) {
            return false;
        }
        TOKEN = result.getStr("token_type") + " " + result.getStr("access_token");
        ACCESS_TOKEN = result.getStr("access_token");
        DriveId = result.getStr("default_drive_id");
        return true;
    }

    /**
     * 获取阿里云文件列表
     * @param fileId 云盘目录ID
     * @return 目录下所有内容
     */
    public static List<CloudFile> getCloudFileList(String fileId) {
        JSONObject data = new JSONObject();
        data.set("drive_id", DriveId);
        data.set("parent_file_id", fileId);
        data.set("limit", 100);
        data.set("all", false);
        data.set("image_thumbnail_process", "image/resize,w_400/format,jpeg");
        data.set("image_url_process", "image/resize,w_1920/format,jpeg");
        data.set("video_thumbnail_process", "video/snapshot,t_0,f_jpg,ar_auto,w_300");
        data.set("fields", "*");
        data.set("url_expire_sec", 1600);
        data.set("order_by", "updated_at");
        data.set("order_direction", "DESC");

        //下一页 标记
        String nextMarker = "";
        JSONArray resultArr = new JSONArray();
        do {
            if (StringUtils.isNotEmpty(nextMarker)) {
                data.set("marker", nextMarker);
            }
            JSONObject result = OkhttpUtil.doPost(FILE_LIST_URL, data);
            resultArr.addAll(result.getJSONArray("items"));
            nextMarker = result.getStr("next_marker");
        } while (StringUtils.isNotEmpty(nextMarker));
        return JSONUtil.toList(resultArr, CloudFile.class);
    }

    /**
     * 获取目录层级信息
     * @param fileId 云盘文件ID
     * @return 目录层级信息
     */
    public static JSONObject getFolderPath(String fileId) {
        JSONObject data = new JSONObject();
        data.set("drive_id", DriveId);
        data.set("file_id", fileId);
        return OkhttpUtil.doPost(FOLDER_PATH_URL, data);
    }

}
