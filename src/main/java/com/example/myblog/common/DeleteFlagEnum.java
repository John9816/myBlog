package com.example.myblog.common;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * 删除枚举
 * created by wangwejie14
 */
@Getter
public enum DeleteFlagEnum {

    NOT_DELETED(1, "正常"),
    DELETED(2, "删除"),
    ;

    private int id;
    private String desc;

    DeleteFlagEnum(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public static DeleteFlagEnum idOf(int id) {
        return Stream.of(DeleteFlagEnum.values())
                .filter(e ->e.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
