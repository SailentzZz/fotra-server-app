package com.fotra.database.repositories;

import com.fotra.database.entities.Answer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Integer> {
    @Query("select max(id_answer) from Answer")
    Integer findFirstById_answer();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Answer SET accepted = :open where id_answer = :id")
    void updateAnswerState(@Param("open") boolean open, @Param("id") Integer id);
}
