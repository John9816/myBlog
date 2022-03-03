package com.example.myblog.mapper;

import com.example.myblog.model.dao.ArticleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by wangweijie14 on 2022/1/12
 */

@Component
@Mapper
public interface ArticleMapper {

    int add(ArticleDO articleDO);

    List<ArticleDO> listAll(@Param("currentPage") Integer currentPage, @Param("perPage") Integer perPage);

    int update(ArticleDO articleDO);
}
