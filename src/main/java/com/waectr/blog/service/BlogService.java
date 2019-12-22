package com.waectr.blog.service;


import com.waectr.blog.service.model.Blog;
import com.waectr.blog.service.model.User;

import java.util.List;

public interface BlogService {

    Blog getBlog(Long id);

    List<Blog> list(String name, User user);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);

    List<Blog> listAll();

    public Blog getBlogAndUser(Long id);
}
