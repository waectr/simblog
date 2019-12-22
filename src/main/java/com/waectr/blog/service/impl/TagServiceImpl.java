package com.waectr.blog.service.impl;

import com.waectr.blog.dao.TagDOMapper;
import com.waectr.blog.dao.TypeDOMapper;
import com.waectr.blog.dataobject.TagDO;
import com.waectr.blog.dataobject.TypeDO;
import com.waectr.blog.service.TagService;
import com.waectr.blog.service.model.Tag;
import com.waectr.blog.service.model.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagDOMapper tagDOMapper;

    @Override
    @Transactional
    public Tag saveTag(Tag tag) {
        TagDO tagDO=convertFromModel(tag);
        tagDOMapper.insertSelective(tagDO);
        int i=tagDO.getId();
        TagDO tagDO1 = tagDOMapper.selectByPrimaryKey(i);
        Tag tag1 = convertFromDataObject(tagDO1);
        return tag1;
    }

    private TagDO convertFromModel(Tag tag) {
        if(tag==null){
            return null;
        }
        TagDO tagDO=new TagDO();
        BeanUtils.copyProperties(tag,tagDO);
        if(tag.getId()!=null){
            tagDO.setId(new Integer(tag.getId().toString()));
        }
        return tagDO;
    }

    private Tag convertFromDataObject(TagDO tagDO){
        if(tagDO==null){
            return null;
        }
        Tag tag=new Tag();
        BeanUtils.copyProperties(tagDO,tag);
        tag.setId(new Long(tagDO.getId()));
        return tag;
    }

    @Override
    public Tag getTag(Long id) {
        TagDO tagDO = tagDOMapper.selectByPrimaryKey(new Integer(id.toString()));
        Tag tag = convertFromDataObject(tagDO);
        return tag;
    }

    @Override
    public List<Tag> list() {
        List<TagDO> tagDOList = tagDOMapper.selectAll();
        List<Tag> tagList=convertFromDataObject(tagDOList);
        return tagList;
    }

    private List<Tag> convertFromDataObject(List<TagDO> tagDOList) {
        if(tagDOList==null){
            return null;
        }
        List<Tag> list=new ArrayList<>();
        for (TagDO tagDO:tagDOList){
            Tag t=new Tag();
            BeanUtils.copyProperties(tagDO,t);
            t.setId(tagDO.getId().longValue());
            list.add(t);
        }
        return list;
    }

    @Override
    @Transactional
    public Tag updateTag(Long id, Tag tag) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tagDOMapper.deleteByPrimaryKey(new Integer(id.toString()));
    }

    @Override
    public List<Tag> ListTag(String ids) {
        List<Long> lists = convertToList(ids);
        List<Tag> tagList=new ArrayList<>();
        for(Long i:lists){
            TagDO tagDO = tagDOMapper.selectByPrimaryKey(new Integer(i.toString()));
            Tag tag = convertFromDataObject(tagDO);
            tagList.add(tag);
        }
        return tagList;
    }

    //获得每个标签的序号
    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                if(idarray[i]!=null) {
                    list.add(new Long(idarray[i]));
                }
            }
        }
        return list;
    }
}