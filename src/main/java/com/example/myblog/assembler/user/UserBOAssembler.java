package com.example.myblog.assembler.user;

import com.example.myblog.model.bo.UserBO;
import com.example.myblog.model.dao.UserDO;

import java.util.Objects;

/**
 * created by wangweijie14 on 2022/4/3
 */
public final class UserBOAssembler {

    public static UserBO toUserBO(UserDO user) {
        if (Objects.isNull(user)) {
            return null;
        }
        return UserBO.childBuilder()
                .id(user.getId())
                .nickName(user.getNickName())
                .account(user.getAccount())
                .password(user.getPassword())
                .gender(user.getGender())
                .avatar(user.getAvatar())
                .isDeleted(user.getIsDeleted())
                .createdTime(user.getCreatedTime())
                .updatedTime(user.getUpdatedTime())
                .build();
    }
}
