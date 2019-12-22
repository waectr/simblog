package com.waectr.blog.service;

import com.waectr.blog.service.model.User;

public interface UserService {

    User checkUser(String username,String password);

}
