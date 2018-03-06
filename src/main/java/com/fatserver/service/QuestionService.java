package com.fatserver.service;

import com.fatserver.entity.Question;
import com.fatserver.entity.User;
import com.fatserver.sendingForms.QuestionForm;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by Victor on 19.02.2018.
 */
public interface QuestionService {


    void save(Question question);

    List<QuestionForm> findAll();

    Question findOne(Long id);

    void delete(Long  id);

    void update(Question question);

}
