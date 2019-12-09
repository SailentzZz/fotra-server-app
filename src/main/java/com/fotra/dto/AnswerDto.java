package com.fotra.dto;

import java.util.Date;

public class AnswerDto {
    private Integer id_post;
    private String body;
    private Integer autor;

    public AnswerDto(Integer id_post, String body, Integer autor) {
        this.id_post = id_post;
        this.body = body;
        this.autor = autor;
    }

    public AnswerDto() {
    }

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getAutor() {
        return autor;
    }

    public void setAutor(Integer autor) {
        this.autor = autor;
    }
}
