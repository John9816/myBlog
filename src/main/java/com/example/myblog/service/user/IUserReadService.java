package com.example.myblog.service.user;

import com.example.myblog.model.bo.UserBO;
import com.example.myblog.model.dao.UserDO;

public interface IUserReadService {

    /**
     * 根据账户获取用户上下文
     * @param account
     */
    UserBO getUserContext(Long account);
}
