package com.example.myblog.model.bo;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryBO {
    private Long    id;
    private String  name;
    private Integer isDeleted;
    private Date    createdTime;
    private Date    updatedTime;
}
