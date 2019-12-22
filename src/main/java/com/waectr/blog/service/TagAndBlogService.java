package com.waectr.blog.service;

import com.waectr.blog.service.model.Tag;

import java.util.List;

//标签和博客的关系
public interface TagAndBlogService {

    public void saveTags(List<Tag> tags,Integer id);

    List<Tag> getTagsByBlogId(Integer id);
}
