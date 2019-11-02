package database.entities;

import javax.persistence.*;

@Entity(name = "LikePost")
@Table(name = "\"LikePost\"", schema = "public")
public class LikePost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_like_post;

    private Integer id_user_like;
    private Integer id_post_like;

    public LikePost() {
    }
    public LikePost(Integer id_like_post, Integer id_user_like, Integer id_post_like) {
        this.id_like_post = id_like_post;
        this.id_user_like = id_user_like;
        this.id_post_like = id_post_like;
    }

    public Integer getId_like_post() {
        return id_like_post;
    }
    public void setId_like_post(Integer id_like_post) {
        this.id_like_post = id_like_post;
    }

    public Integer getId_user_like() {
        return id_user_like;
    }
    public void setId_user_like(Integer id_user_like) {
        this.id_user_like = id_user_like;
    }

    public Integer getId_post_like() {
        return id_post_like;
    }
    public void setId_post_like(Integer id_post_like) {
        this.id_post_like = id_post_like;
    }

    @Override
    public String toString() {
        return "LikePost{" +
                "id_like_post=" + id_like_post +
                ", id_user_like=" + id_user_like +
                ", id_post_like=" + id_post_like +
                '}';
    }
}