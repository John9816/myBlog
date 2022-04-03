package com.example.myblog.model.dao;

import lombok.Data;

import java.util.Date;

@Data
public class UserDO {
    private Long    id;
    private String  nickName;
    private Long    account;
    private String  password;
    private Integer  gender;
    private String  avatar;
    private Integer isDeleted;
    private Date    createdTime;
    private Date    updatedTime;
}
