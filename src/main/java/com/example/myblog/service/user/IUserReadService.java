package com.example.myblog.service.user;

import com.example.myblog.model.bo.UserBO;

public interface IUserReadService {

    /**
     * 登录 且返回token
     * @param account 账户
     * @param password 密码
     */
    UserBO login(Long account, String password);

    /**
     * 根据账户获取用户上下文
     * @param account
     */
    UserBO getUserContext(Long account);
}
