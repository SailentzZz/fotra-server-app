package com.fotra.database.repositories;

import com.fotra.database.entities.LikePost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePostRepo extends CrudRepository<LikePost, Integer> {
    @Query("SELECT id_user_like, id_post_like, id_like_post FROM LikePost WHERE id_post_like = :post_id AND id_user_like = :user_id")
    LikePost findLikePostById_user_likeAndId_post_like(@Param("post_id")Integer post_id, @Param("user_id")Integer user_id);
}
