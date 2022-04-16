package com.example.myblog.model.dao;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryDO {
    private Long    id;
    private String  name;
    private Integer isDeleted;
    private Date    createdTime;
    private Date    updatedTime;
}
