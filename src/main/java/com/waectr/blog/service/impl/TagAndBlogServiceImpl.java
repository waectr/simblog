package com.waectr.blog.service.impl;

import com.waectr.blog.dao.BlogAndTagDOMapper;
import com.waectr.blog.dataobject.BlogAndTagDOKey;
import com.waectr.blog.dataobject.TagDO;
import com.waectr.blog.service.TagAndBlogService;
import com.waectr.blog.service.TagService;
import com.waectr.blog.service.model.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagAndBlogServiceImpl implements TagAndBlogService {
    @Autowired
    BlogAndTagDOMapper blogAndTagDOMapper;

    @Override
    public void saveTags(List<Tag> tags, Integer id){
        if(tags!=null){
            for (Tag t:tags) {
                BlogAndTagDOKey blogAndTagDOKey1 = blogAndTagDOMapper.selectOne(new Integer(t.getId().toString()), id);
                if(blogAndTagDOKey1==null) {
                    BlogAndTagDOKey blogAndTagDOKey = new BlogAndTagDOKey();
                    blogAndTagDOKey.setBlogId(id);
                    blogAndTagDOKey.setTagId(new Integer(t.getId().toString()));
                    blogAndTagDOMapper.insertSelective(blogAndTagDOKey);
                }
            }
        }
    }

    @Override
    public List<Tag> getTagsByBlogId(Integer id) {
        List<BlogAndTagDOKey> blogAndTagDOKeys = blogAndTagDOMapper.selectByBid(id);
        List<Tag> tagList=convertFromtagDO(blogAndTagDOKeys);
        return tagList;
    }

    private List<Tag> convertFromtagDO(List<BlogAndTagDOKey> blogAndTagDOKeys) {
        if(blogAndTagDOKeys==null){
            return null;
        }
        List<Tag> tagList=new ArrayList<>();
        for(BlogAndTagDOKey t:blogAndTagDOKeys){
            Tag tag = new Tag();
            BeanUtils.copyProperties(t,tag);
            tagList.add(tag);
        }
        return tagList;
    }
}
