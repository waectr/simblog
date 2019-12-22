package com.waectr.blog.service.impl;

import com.waectr.blog.dao.BlogDOMapper;
import com.waectr.blog.dao.TagDOMapper;
import com.waectr.blog.dao.TypeDOMapper;
import com.waectr.blog.dao.UserDOMapper;
import com.waectr.blog.dataobject.BlogDO;
import com.waectr.blog.dataobject.TypeDO;
import com.waectr.blog.dataobject.UserDO;
import com.waectr.blog.handler.NotFoundException;
import com.waectr.blog.service.BlogService;
import com.waectr.blog.service.TagAndBlogService;
import com.waectr.blog.service.model.Blog;
import com.waectr.blog.service.model.Tag;
import com.waectr.blog.service.model.Type;
import com.waectr.blog.service.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogDOMapper blogDOMapper;

    @Autowired
    TagDOMapper tagDOMapper;

    @Autowired
    TagAndBlogService tagAndBlogService;

    @Autowired
    TypeDOMapper typeDOMapper;

    @Autowired
    UserDOMapper userDOMapper;

    @Override
    public Blog getBlog(Long id) {
        BlogDO blogDO = blogDOMapper.selectByPrimaryKey(new Integer(id.toString()));
        TypeDO typeDO = typeDOMapper.selectByTypeId(blogDO.getTypeId());
        Type type=new Type();
        type.setId(new Long(typeDO.getId()));
        type.setName(typeDO.getName());
        Blog blog=convertFromBlogDO(blogDO);
        blog.setType(type);
        return blog;
    }

    public Blog getBlogAndUser(Long id){
        BlogDO blogDO = blogDOMapper.selectByPrimaryKey(new Integer(id.toString()));
        Blog blog = getBlog(id);
        Integer userId = blogDO.getUserId();
        UserDO userDO = userDOMapper.selectByPrimaryKey(userId);
        User user = convertFromUserDO(userDO);
        blog.setUser(user);
        return blog;
    }

    private Blog convertFromBlogDO(BlogDO blogDO) {
        if(blogDO==null){
            return null;
        }
        Blog blog=new Blog();
        BeanUtils.copyProperties(blogDO,blog);
        if(blogDO.getPublished()==1){
            blog.setPublished(true);
        }else {
            blog.setPublished(false);
        }

        if(blogDO.getAppreciation()==1){
            blog.setAppreciation(true);
        }else {
            blog.setAppreciation(false);
        }

        if(blogDO.getCommentabled()==1){
            blog.setCommenttabled(true);
        }else {
            blog.setCommenttabled(false);
        }

        if(blogDO.getRecommend()==1){
            blog.setRecommend(true);
        }else {
            blog.setRecommend(false);
        }

        if(blogDO.getSharestatement()==1){
            blog.setShareStatement(true);
        }else {
            blog.setShareStatement(false);
        }

        if(blogDO!=null){
            blog.setId(new Long(blogDO.getId().toString()));
        }

        return blog;
    }

    @Override
    public List<Blog> list(String name, User user) {
        List<BlogDO> blogDOS = blogDOMapper.selectByLike(name,new Integer(user.getId().toString()));
        ArrayList<Blog> blogsList=new ArrayList<>();
        if(blogDOS!=null) {
            for (BlogDO blogDO : blogDOS) {
                Blog blog1 = convertFromBlogDO(blogDO);
                blogsList.add(blog1);
            }
        }
        return blogsList;
    }

    @Override
    @Transactional
    public Blog saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setViews(0);
        blog.setUpdateTime(new Date());
        BlogDO blogDO = convertFromBlog(blog);
        BlogDO blogDO2 = blogDOMapper.selectByPrimaryKey(blogDO.getId());
        if(blogDO2==null) {
            blogDOMapper.insert(blogDO);
        }else {
            blogDOMapper.updateByPrimaryKey(blogDO);
        }
        Integer id = new Integer(blogDO.getId().toString());
        BlogDO blogDO1 = blogDOMapper.selectByPrimaryKey(id);
        //将标签和文章的关系存起来
        List<Tag> tags = blog.getTags();
        tagAndBlogService.saveTags(tags,blogDO1.getId());
        Blog blog1 = convertFromBlogDO(blogDO1);
        return blog1;
    }

    private BlogDO convertFromBlog(Blog blog) {
        if(blog==null){
            return null;
        }
        BlogDO blogDO=new BlogDO();
        BeanUtils.copyProperties(blog,blogDO);
        if(blog.isAppreciation()){
            blogDO.setAppreciation(1);
        }else {
            blogDO.setAppreciation(0);
        }

        if(blog.isCommenttabled()){
            blogDO.setCommentabled(1);
        }else {
            blogDO.setCommentabled(0);
        }

        if(blog.isPublished()){
            blogDO.setPublished(1);
        }else {
            blogDO.setPublished(0);
        }

        if(blog.isRecommend()){
            blogDO.setRecommend(1);
        }else {
            blogDO.setRecommend(0);
        }

        if(blog.isShareStatement()){
            blogDO.setSharestatement(1);
        }else {
            blogDO.setSharestatement(0);
        }

        if(blog.getId()!=null){
            blogDO.setId(new Integer(blog.getId().toString()));
        }

        blogDO.setUserId(new Integer(blog.getUser().getId().toString()));
        blogDO.setTypeId(new Integer(blog.getType().getId().toString()));

        return blogDO;
    }


    @Override
    public Blog updateBlog(Long id, Blog blog) {
        BlogDO b=blogDOMapper.selectByPrimaryKey(new Integer(id.toString()));
        if(b==null){
            throw new NotFoundException("该博客不存在");
        }

        Blog blog1 = convertFromBlogDO(b);
        BeanUtils.copyProperties(blog,blog1);
        BlogDO blogDO = convertFromBlog(blog1);
        blogDOMapper.insertSelective(blogDO);
        return blog1;
    }

    @Override
    @Transactional
    public void deleteBlog(Long id) {
        blogDOMapper.deleteByPrimaryKey(new Integer(id.toString()));
    }

    @Override
    public List<Blog> listAll() {
        List<BlogDO> blogDOS = blogDOMapper.selectAll();
        List<Blog> list = convertFromBlogDOAndAddUser(blogDOS);
        return list;
    }

    private List<Blog> convertFromBlogDOAndAddUser(List<BlogDO> blogDOS){
        if(blogDOS==null){
            return null;
        }
        List<Blog> list=new ArrayList<>();
        for(BlogDO b:blogDOS){
            Blog blog = convertFromBlogDO(b);
            UserDO userDO = userDOMapper.selectByPrimaryKey(b.getUserId());
            User user=convertFromUserDO(userDO);
            blog.setUser(user);
            list.add(blog);
        }
        return list;
    }

    public User convertFromUserDO(UserDO userDO) {
        User user=new User();
        user.setId(new Long(userDO.getId()));
        user.setNickname(userDO.getNickname());
        return user;
    }

//    private List<Blog> addUser(List<Blog> list) {
//        if(list==null){
//            return null;
//        }
//
//    }


    private List<Blog> convertFromBlogDO(List<BlogDO> blogDOS){
        if(blogDOS==null){
            return null;
        }
        List<Blog> lists=new ArrayList<>();
        for(BlogDO b:blogDOS){
            Blog blog = convertFromBlogDO(b);
            lists.add(blog);
        }
        return lists;
    }

}