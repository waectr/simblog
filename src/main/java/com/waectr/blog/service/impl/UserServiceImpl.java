package com.waectr.blog.service.impl;

import com.waectr.blog.dao.UserDOMapper;
import com.waectr.blog.dataobject.UserDO;
import com.waectr.blog.service.UserService;
import com.waectr.blog.service.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDOMapper userDOMapper;

    @Override
    public User checkUser(String username, String password) {
        UserDO userDO = userDOMapper.selectByUsername(username);
        if(userDO==null){
            return null;
        }else {
            //密码相等
            if(userDO.getPassword().equals(password)){
                User user=convertFromDataObject(userDO);
                return user;
            }else {
                return null;
            }
        }
    }

    private User convertFromDataObject(UserDO userDO) {
        if(userDO==null){
            return null;
        }
        User user=new User();
        BeanUtils.copyProperties(userDO,user);
        user.setId(Long.valueOf(userDO.getId().toString()));
        return user;
    }
}
