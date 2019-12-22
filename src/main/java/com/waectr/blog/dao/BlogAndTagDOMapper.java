package com.waectr.blog.dao;

import com.waectr.blog.dataobject.BlogAndTagDOKey;
import com.waectr.blog.dataobject.TagDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogAndTagDOMapper {

    int deleteByPrimaryKey(BlogAndTagDOKey key);

    int insert(BlogAndTagDOKey record);

    int insertSelective(BlogAndTagDOKey record);

    List<BlogAndTagDOKey> selectByBid(Integer id);

    BlogAndTagDOKey selectOne(@Param("tagId") Integer tagId,@Param("blogId") Integer blogId);
}