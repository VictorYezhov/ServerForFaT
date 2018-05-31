package com.fatserver.service;

import com.fatserver.entity.Question;
import com.fatserver.dto.SendQuestionDTO;
import com.fatserver.entity.User;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Victor on 19.02.2018.
 */
public interface QuestionService {


    void save(Question question);

    List<SendQuestionDTO> findAll();

    Question findOne(Long id);

    void delete(Long  id);

    void update(Question question);


    List<SendQuestionDTO> findAllByCategoty(Long categoryId);

    Question findQuestionByDateTimeAndUser(Timestamp time, User user);
}
