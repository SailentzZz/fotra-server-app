package com.fotra.database.repositories;

import com.fotra.database.entities.LikeAnswer;
import com.fotra.database.entities.LikePost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeAnswerRepo extends CrudRepository<LikeAnswer, Integer> {
    @Query("SELECT id_user_like, id_answer_like, id_like_answer FROM LikeAnswer WHERE id_answer_like = :answer_id AND id_user_like = :user_id")
    LikeAnswer findLikePostById_user_likeAndId_post_like(@Param("answer_id")Integer answer_id, @Param("user_id")Integer user_id);
}
