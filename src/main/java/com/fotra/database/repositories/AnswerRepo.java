package com.fotra.database.repositories;

import com.fotra.database.entities.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Integer> {
    @Query("select max(id_answer) from Answer")
    Integer findFirstById_answer();
}
