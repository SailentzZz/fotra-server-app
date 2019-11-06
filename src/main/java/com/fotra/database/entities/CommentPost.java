package com.fotra.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "CommentPost")
@Table(name = "\"CommentPost\"", schema = "public")
public class CommentPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_comment_post;

    private Integer post_id_var;
    private Integer comment_id_var;

    public CommentPost() {
    }
    public CommentPost(Integer id_comment_post, Integer post_id_var, Integer comment_id_var) {
        this.id_comment_post = id_comment_post;
        this.post_id_var = post_id_var;
        this.comment_id_var = comment_id_var;
    }

    public Integer getId_comment_post() {
        return id_comment_post;
    }
    public void setId_comment_post(Integer id_comment_post) {
        this.id_comment_post = id_comment_post;
    }

    public Integer getPost_id_var() {
        return post_id_var;
    }
    public void setPost_id_var(Integer post_id_var) {
        this.post_id_var = post_id_var;
    }

    public Integer getComment_id_var() {
        return comment_id_var;
    }
    public void setComment_id_var(Integer comment_id_var) {
        this.comment_id_var = comment_id_var;
    }

    @Override
    public String toString() {
        return "CommentPost{" +
                "id_comment_post=" + id_comment_post +
                ", post_id_var=" + post_id_var +
                ", comment_id_var=" + comment_id_var +
                '}';
    }
}