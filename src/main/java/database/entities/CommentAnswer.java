package database.entities;

import javax.persistence.*;

@Entity(name = "CommentAnswer")
@Table(name = "\"CommentAnswer\"", schema = "public")
public class CommentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_comment_answer;

    private Integer answer_id_var;
    private Integer comment_id_var;

    public CommentAnswer() {
    }
    public CommentAnswer(Integer id_comment_answer, Integer answer_id_var, Integer comment_id_var) {
        this.id_comment_answer = id_comment_answer;
        this.answer_id_var = answer_id_var;
        this.comment_id_var = comment_id_var;
    }

    public Integer getId_comment_answer() {
        return id_comment_answer;
    }
    public void setId_comment_answer(Integer id_comment_answer) {
        this.id_comment_answer = id_comment_answer;
    }

    public Integer getAnswer_id_var() {
        return answer_id_var;
    }
    public void setAnswer_id_var(Integer answer_id_var) {
        this.answer_id_var = answer_id_var;
    }

    public Integer getComment_id_var() {
        return comment_id_var;
    }
    public void setComment_id_var(Integer comment_id_var) {
        this.comment_id_var = comment_id_var;
    }


}