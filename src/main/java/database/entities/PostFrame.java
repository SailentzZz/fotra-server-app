package database.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PostFrame")
@Table(name = "\"PostFrame\"", schema = "public")
public class PostFrame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_post;

    private Integer autor;
    private String head;
    private String body;
    private Date date;
    private Integer likes;
    private Integer comments;
    private Boolean open_close;
    private Integer topic_var;

    public PostFrame() {
    }
    public PostFrame(Integer id_post, Integer autor, String head, String body, Date date, Integer likes, Integer comments, Boolean open_close, Integer topic_var) {
        this.id_post = id_post;
        this.autor = autor;
        this.head = head;
        this.body = body;
        this.date = date;
        this.likes = likes;
        this.comments = comments;
        this.open_close = open_close;
        this.topic_var = topic_var;
    }

    public Integer getId_post() {
        return id_post;
    }
    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public Integer getAutor() {
        return autor;
    }
    public void setAutor(Integer autor) {
        this.autor = autor;
    }

    public String getHead() {
        return head;
    }
    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
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

    public Boolean getOpen_close() {
        return open_close;
    }
    public void setOpen_close(Boolean open_close) {
        this.open_close = open_close;
    }

    public Integer getTopic_var() {
        return topic_var;
    }
    public void setTopic_var(Integer topic_var) {
        this.topic_var = topic_var;
    }

    @Override
    public String toString() {
        return "PostFrame{" +
                "id_post=" + id_post +
                ", autor=" + autor +
                ", head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                ", likes=" + likes +
                ", comments=" + comments +
                ", open_close=" + open_close +
                ", topic_var=" + topic_var +
                '}';
    }
}