package com.example.myblog.common.utils;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.myblog.common.constant.AliYunConstant;
import com.example.myblog.common.constant.DictConstants;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.util.concurrent.TimeUnit;

@Slf4j
public class OkhttpUtil {

    /**
     * 阿里云盘交互的POST请求
     * @param url
     * @param data
     * @return
     * @throws Exception
     */
    public synchronized static JSONObject doPost(String url, JSONObject data) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(5, TimeUnit.MINUTES).build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType,data.toString());
            Request request = new Request.Builder()
                    .url(url)
                    .method("POST", body)
                    .addHeader("authorization", AliYunConstant.TOKEN)
                    .addHeader("Content-Type", "application/json").build();
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            String urlDict = DictConstants.URI_DICT.get(url);
            if (429==response.code()){
                log.info("请求频繁了，休息一下。。。。正在准备重试中。。。");
                ThreadUtil.sleep(5000);
                return doPost(url,data);
            }
            JSONObject json = JSONUtil.parseObj(result);
            return json;
        } catch (Exception e) {
            return null;
        }
    }

}
