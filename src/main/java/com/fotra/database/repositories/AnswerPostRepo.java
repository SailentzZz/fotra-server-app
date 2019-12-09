package com.fotra.database.repositories;

import com.fotra.database.entities.PostAnswers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AnswerPostRepo extends CrudRepository<PostAnswers, Integer> {
    @Query(value = "select sub.post_id_var, sub.id_answer, sub.body, name, sub.date, sub.likes, sub.comments, sub.accepted\n" +
            "from (select \"PostAnswers\".post_id_var, \"Answer\".*\n" +
            "from \"PostAnswers\" join \"Answer\" on \"PostAnswers\".answer_id = \"Answer\".id_answer\n" +
            "where post_id_var = :id) as sub\n" +
            "join \"UserForum\" on sub.autor = \"UserForum\".id_user", nativeQuery = true)
    Iterable<PostAnswerReqDtoRepo> findAllPostsAnswersWithUser(@Param("id") Integer id);

    public static interface PostAnswerReqDtoRepo {

        public String getPost_id_var();

        public String getId_answer();

        public String getBody();

        public String getName();

        public Date getDate();

        public Integer getLikes();

        public Integer getComments();

        public Boolean getAccepted();;
    }
}
