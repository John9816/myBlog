package com.example.myblog.model.request.user;

import com.example.myblog.model.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class ConsoleGetUserContextRequest extends BaseRequest {

    /**
     * 账户
     */
    private Long account;

    /**
     * 密码
     */
    private String password;

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

}
