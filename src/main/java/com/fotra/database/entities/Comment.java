package com.fotra.database.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Comment")
@Table(name = "\"Comment\"", schema = "public")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_comment;

    private Integer autor;
    private Date date;
    private String body;
    private Integer to_user;

    public Comment() {
    }

    public Comment(Integer id_comment, Integer autor, Date date, String body, Integer to_user) {
        this.id_comment = id_comment;
        this.autor = autor;
        this.date = date;
        this.body = body;
        this.to_user = to_user;
    }

    public Integer getId_comment() {
        return id_comment;
    }
    public void setId_comment(Integer id_comment) {
        this.id_comment = id_comment;
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

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public Integer getTo_user() {
        return to_user;
    }
    public void setTo_user(Integer to_user) {
        this.to_user = to_user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id_comment=" + id_comment +
                ", autor=" + autor +
                ", date=" + date +
                ", body='" + body + '\'' +
                ", to_user=" + to_user +
                '}';
    }
}
