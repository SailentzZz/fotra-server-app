package com.fotra.dto;

public class LikePost {
    private Integer id_user;
    private Integer id_post;

    public LikePost() {
    }

    public LikePost(Integer id_user, Integer id_post) {
        this.id_user = id_user;
        this.id_post = id_post;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }
}
