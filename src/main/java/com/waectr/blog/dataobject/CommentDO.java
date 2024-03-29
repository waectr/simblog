package com.waectr.blog.dataobject;

import java.util.Date;

public class CommentDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.id
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.avatar
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    private String avatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.content
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.create_time
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.email
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.nickname
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.blog_id
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    private Integer blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.parent_comment_id
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    private Integer parentCommentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.id
     *
     * @return the value of t_comment.id
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.id
     *
     * @param id the value for t_comment.id
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.avatar
     *
     * @return the value of t_comment.avatar
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.avatar
     *
     * @param avatar the value for t_comment.avatar
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.content
     *
     * @return the value of t_comment.content
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.content
     *
     * @param content the value for t_comment.content
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.create_time
     *
     * @return the value of t_comment.create_time
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.create_time
     *
     * @param createTime the value for t_comment.create_time
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.email
     *
     * @return the value of t_comment.email
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.email
     *
     * @param email the value for t_comment.email
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.nickname
     *
     * @return the value of t_comment.nickname
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.nickname
     *
     * @param nickname the value for t_comment.nickname
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.blog_id
     *
     * @return the value of t_comment.blog_id
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public Integer getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.blog_id
     *
     * @param blogId the value for t_comment.blog_id
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.parent_comment_id
     *
     * @return the value of t_comment.parent_comment_id
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public Integer getParentCommentId() {
        return parentCommentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.parent_comment_id
     *
     * @param parentCommentId the value for t_comment.parent_comment_id
     *
     * @mbg.generated Sun Dec 15 20:26:20 CST 2019
     */
    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }
}