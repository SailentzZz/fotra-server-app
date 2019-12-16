package com.fotra.dto;

public class LikeAnswerDto {
    private Integer id_user;
    private Integer id_answer;

    public LikeAnswerDto() {
    }

    public LikeAnswerDto(Integer id_user, Integer id_answer) {
        this.id_user = id_user;
        this.id_answer = id_answer;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_answer() {
        return id_answer;
    }

    public void setId_answer(Integer id_answer) {
        this.id_answer = id_answer;
    }
}
