package com.example.myblog.common.utils;

import com.google.gson.Gson;


public final class JsonUtil {

    private static Gson gson = new Gson();


    public static String toJson(Object o) {
        return gson.toJson(o);
    }
}
