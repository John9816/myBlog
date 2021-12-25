package com.example.myblog.common.utils;

import java.util.Arrays;
import java.util.Objects;

/**
 * created by wangweijie14 on 2021/12/25
 */
public final class ParameterCheckUtils {
    public ParameterCheckUtils() {
    }

    public static boolean isValidPrimaryKeys(Long... primaryKeys) {
        return 0 != primaryKeys.length && Arrays.stream(primaryKeys).allMatch(ParameterCheckUtils::isValidPrimaryKey);
    }
    public static boolean isValidPrimaryKey(Long primaryKey) {
        return Objects.nonNull(primaryKey) && primaryKey > 0L;
    }
}
