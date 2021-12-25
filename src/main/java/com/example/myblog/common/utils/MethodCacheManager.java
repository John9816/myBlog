package com.example.myblog.common.utils;


import com.example.myblog.common.constant.MethodNameConstant;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 方法缓存管理器
 * created by wangweijie14 on 2021/12/25
 */
public class MethodCacheManager {
    private static final String DOT = ".";

    //方法缓存容器
    private static ConcurrentHashMap<String, Method> caches = new ConcurrentHashMap<>();

    public MethodCacheManager() {

    }

    public static Method fetchMethod(Class<?> clazz, String methodName) {
        if (clazz == null || StringUtils.isEmpty(methodName)) {
            return null;
        }
        String key = buildCacheKey(clazz, methodName);
        Method method = caches.get(key);
        if (method == null) {
            initCache(clazz);
        }
        method = caches.get(key);
        return method;
    }

    /**
     * 初始化缓存
     * @param clazz
     */
    private static void initCache(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        if (null == methods) {
            return;
        }
        for(Method method :methods) {
            String methodName = method.getName();
            if (isNeedCache(methodName)) {
                caches.put(buildCacheKey(clazz, methodName), method);
            }
        }

    }

    private static boolean isNeedCache(String methodName) {
        if (MethodNameConstant.SET_DATA.equals(methodName) || MethodNameConstant.SET_STATUS.equals(methodName)) {
            return true;
        }
        return false;
    }

    private static String buildCacheKey(Class<?> clazz, String methodName) {
        StringBuilder builder = new StringBuilder(32);
        builder.append(clazz.getName()).append(DOT).append(methodName);

        return builder.toString();
    }
}
