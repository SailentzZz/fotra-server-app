package com.fotra.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PostAnswer")
@Table(name = "\"PostAnswer\"", schema = "public")
public class PostAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_post_answer;

    private Integer post_id_var;
    private Integer answer_id;

    public PostAnswer() {
    }
    public PostAnswer(Integer id_post_answer, Integer post_id_var, Integer answer_id) {
        this.id_post_answer = id_post_answer;
        this.post_id_var = post_id_var;
        this.answer_id = answer_id;
    }

    public Integer getId_post_answer() {
        return id_post_answer;
    }
    public void setId_post_answer(Integer id_post_answer) {
        this.id_post_answer = id_post_answer;
    }

    public Integer getPost_id_var() {
        return post_id_var;
    }
    public void setPost_id_var(Integer post_id_var) {
        this.post_id_var = post_id_var;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }
    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    @Override
    public String toString() {
        return "PostAnswer{" +
                "id_post_answer=" + id_post_answer +
                ", post_id_var=" + post_id_var +
                ", answer_id=" + answer_id +
                '}';
    }
}