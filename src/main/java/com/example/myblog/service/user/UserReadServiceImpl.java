package com.example.myblog.service.user;

import com.example.myblog.assembler.user.UserBOAssembler;
import com.example.myblog.mapper.UserMapper;
import com.example.myblog.model.bo.UserBO;
import com.example.myblog.model.dao.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserReadServiceImpl implements IUserReadService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserBO getUserContext(Long account) {
        UserDO userDO = userMapper.listByAccount(account);
        return UserBOAssembler.toUserBO(userDO);
    }
}
