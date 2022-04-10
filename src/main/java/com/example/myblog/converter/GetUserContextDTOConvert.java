package com.example.myblog.converter;

import com.example.myblog.common.DeleteFlagEnum;
import com.example.myblog.model.bo.UserBO;
import com.example.myblog.model.dto.user.GetUserContextDTO;

public class GetUserContextDTOConvert {

    public static GetUserContextDTO toGetUserContextDTO(UserBO user) {
        GetUserContextDTO userContext = new GetUserContextDTO();
        userContext.setId(user.getId());
        userContext.setAccount(user.getAccount());
        userContext.setNickName(user.getNickName());
        userContext.setGender(user.getGender());
        userContext.setAvatar(user.getAvatar());
        userContext.setCreatedTime(user.getCreatedTime().getTime());
        userContext.setUpdatedTime(user.getUpdatedTime().getTime());
        userContext.setIsDeleted(DeleteFlagEnum.idOf(user.getIsDeleted()) == DeleteFlagEnum.NOT_DELETED);
        return userContext;

    }
}
