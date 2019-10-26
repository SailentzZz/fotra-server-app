package repos.entities;

import javax.persistence.*;

@Entity(name = "LikeAnswer")
@Table(name = "\"LikeAnswer\"", schema = "public")
public class LikeAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_like_answer;

    private Integer id_user_like;
    private Integer id_answer_like;

    public LikeAnswer() {
    }
    public LikeAnswer(Integer id_like_answer, Integer id_user_like, Integer id_answer_like) {
        this.id_like_answer = id_like_answer;
        this.id_user_like = id_user_like;
        this.id_answer_like = id_answer_like;
    }

    public Integer getId_like_answer() {
        return id_like_answer;
    }
    public void setId_like_answer(Integer id_like_answer) {
        this.id_like_answer = id_like_answer;
    }

    public Integer getId_user_like() {
        return id_user_like;
    }
    public void setId_user_like(Integer id_user_like) {
        this.id_user_like = id_user_like;
    }

    public Integer getId_answer_like() {
        return id_answer_like;
    }
    public void setId_answer_like(Integer id_answer_like) {
        this.id_answer_like = id_answer_like;
    }
}