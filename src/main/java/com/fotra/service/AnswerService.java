package com.fotra.service;

import com.fotra.database.entities.Answer;
import com.fotra.database.entities.PostAnswers;
import com.fotra.database.repositories.AnswerPostRepo;
import com.fotra.database.repositories.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.Date;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private AnswerPostRepo answerPostRepo;

    public boolean addAnswerToPost(Answer answer, Integer postId) {
        try {
            answerRepo.save(answer);
            Integer a = answerRepo.findFirstById_answer();

            PostAnswers pa = new PostAnswers(postId, a);
            answerPostRepo.save(pa);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public Iterable<AnswerPostRepo.PostAnswerReqDtoRepo> getAnswerPostFrame(Integer postId) {
        try {
            return answerPostRepo.findAllPostsAnswersWithUser(postId);
        } catch (RuntimeException e) {
            return null;
        }
    }

    public boolean updateAnswerState(Integer id, boolean open) {
        try {
            answerRepo.updateAnswerState(open, id);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
