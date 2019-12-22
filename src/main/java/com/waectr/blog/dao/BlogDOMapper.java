package com.waectr.blog.dao;

import com.waectr.blog.dataobject.BlogDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BlogDO record);

    int insertSelective(BlogDO record);

    BlogDO selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(BlogDO record);

    int updateByPrimaryKey(BlogDO record);

    List<BlogDO> selectAll();

    List<BlogDO> selectByLike(@Param("name") String name,@Param("id") Integer id);
}