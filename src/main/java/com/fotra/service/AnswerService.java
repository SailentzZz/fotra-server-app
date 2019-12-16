package com.fotra.service;

import com.fotra.database.entities.*;
import com.fotra.database.repositories.AnswerPostRepo;
import com.fotra.database.repositories.AnswerRepo;
import com.fotra.database.repositories.LikeAnswerRepo;
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

    @Autowired
    private LikeAnswerRepo likeAnswerRepo;

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

    public boolean setLikeAnswer(Integer id_answer, Integer id_user) {
        try {
            LikeAnswer likeAnswer = null;
            likeAnswer = likeAnswerRepo.findLikePostById_user_likeAndId_post_like(id_answer, id_user);
            if (likeAnswer == null){
                Answer frame = answerRepo.findById(id_answer).get();
                frame.setLikes(frame.getLikes() + 1);
                answerRepo.save(frame);
                LikeAnswer tmp = new LikeAnswer(id_user, id_answer);
                likeAnswerRepo.save(tmp);
                return true;
            } else {
                return false;
            }
        } catch (RuntimeException e) {
            return false;
        }
    }
}
