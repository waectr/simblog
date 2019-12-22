package com.waectr.blog.service.model;

import java.util.ArrayList;
import java.util.List;

public class Type {

    private Long id;
    private String name;
    private List<Blog> blogs=new ArrayList<>();

    public Type() {
    }


    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
