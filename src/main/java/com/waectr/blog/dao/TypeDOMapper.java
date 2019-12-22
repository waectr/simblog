package com.waectr.blog.dao;

import com.waectr.blog.dataobject.TypeDO;
import com.waectr.blog.service.model.Type;

import java.util.List;

public interface TypeDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TypeDO record);

    int insertSelective(TypeDO record);

    TypeDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypeDO record);

    int updateByPrimaryKey(TypeDO record);


    List<TypeDO> selectAll();

    TypeDO selectByTypeId(Integer id);
}