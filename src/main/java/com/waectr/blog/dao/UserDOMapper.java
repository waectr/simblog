package com.waectr.blog.dao;

import com.waectr.blog.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;

public interface UserDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    UserDO selectByUsername(@Param("username") String username);
}