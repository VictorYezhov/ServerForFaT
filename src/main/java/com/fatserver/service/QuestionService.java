package com.fatserver.service;

import com.fatserver.entity.Question;
import com.fatserver.entity.User;

import java.util.List;

/**
 * Created by Victor on 19.02.2018.
 */
public interface QuestionService {


    void save(Question question);

    List<Question> findAll();

    Question findOne(Long id);

    void delete(Long  id);

    void update(Question question);

}
