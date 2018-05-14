package com.fatserver.service;

import com.fatserver.entity.Question;
import com.fatserver.sendingForms.QuestionDTO;

import java.util.List;

/**
 * Created by Victor on 19.02.2018.
 */
public interface QuestionService {


    void save(Question question);

    List<QuestionDTO> findAll();

    Question findOne(Long id);

    void delete(Long  id);

    void update(Question question);


    List<QuestionDTO> findAllByCategoty(Long categoryId);

}
