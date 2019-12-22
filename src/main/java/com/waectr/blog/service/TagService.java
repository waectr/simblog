package com.waectr.blog.service;

import com.waectr.blog.service.model.Tag;
import com.waectr.blog.service.model.Type;

import java.util.List;

public interface TagService {

    //保存
    Tag saveTag(Tag tag);

    //查询
    Tag getTag(Long id);

    //获取全部
    List<Tag> list();

    Tag updateTag(Long id, Tag tag);

    void delete(Long id);

    List<Tag> ListTag(String ids);

}
