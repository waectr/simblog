package com.waectr.blog.dao;

import com.waectr.blog.dataobject.TagDO;

import java.util.List;

public interface TagDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TagDO record);

    int insertSelective(TagDO record);

    TagDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagDO record);

    int updateByPrimaryKey(TagDO record);

    List<TagDO> selectAll();
}