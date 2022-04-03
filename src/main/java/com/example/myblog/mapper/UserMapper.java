package com.example.myblog.mapper;

import com.example.myblog.model.dao.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


/**
 * created by wangweijie14 on 2022/1/12
 */

@Component
@Mapper
public interface UserMapper {

    UserDO listByAccount(@Param("account") Long account);
}
