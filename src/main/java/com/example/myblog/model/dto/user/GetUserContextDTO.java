package com.example.myblog.model.dto.user;

import com.example.myblog.model.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetUserContextDTO extends BaseDTO {

    /**
     * 账户
     */
    private Long account;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private int gender;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 是否删除 1正常 2删除
     */
    private Boolean isDeleted;
}
