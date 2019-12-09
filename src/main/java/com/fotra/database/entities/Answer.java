package com.fotra.database.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Answer")
@Table(name = "\"Answer\"", schema = "public")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_answer;

    private String body;
    private Integer autor;
    private Date date;
    private Integer likes;
    private Integer comments;
    private Boolean accepted;

    public Answer() {
    }
    public Answer(Integer id_answer, String body, Integer autor, Date date, Integer likes, Integer comments, Boolean accepted) {
        this.id_answer = id_answer;
        this.body = body;
        this.autor = autor;
        this.date = date;
        this.likes = likes;
        this.comments = comments;
        this.accepted = accepted;
    }

    public Answer(String body, Integer autor, Date date, Integer likes, Integer comments, Boolean accepted) {
        this.body = body;
        this.autor = autor;
        this.date = date;
        this.likes = likes;
        this.comments = comments;
        this.accepted = accepted;
    }

    public Integer getId_answer() {
        return id_answer;
    }
    public void setId_answer(Integer id_answer) {
        this.id_answer = id_answer;
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

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getLikes() {
        return likes;
    }
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getComments() {
        return comments;
    }
    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Boolean getAccepted() {
        return accepted;
    }
    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id_answer=" + id_answer +
                ", body='" + body + '\'' +
                ", autor=" + autor +
                ", date=" + date +
                ", likes=" + likes +
                ", comments=" + comments +
                ", accepted=" + accepted +
                '}';
    }
}