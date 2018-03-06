package com.fatserver.service;

import com.fatserver.dao.QuestionDao;
import com.fatserver.entity.Question;
import com.fatserver.entity.User;
import com.fatserver.sendingForms.QuestionForm;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Victor on 19.02.2018.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;


    @Override
    public void save(Question question) {
        questionDao.save(question);
    }

    @Override
    public List<QuestionForm> findAll() {
        List<Question> questions =  questionDao.findAll();
        List<QuestionForm> forms = new ArrayList<>();

        QuestionForm qf;
        for (Question q: questions ) {
            qf = new QuestionForm();
            qf.setQuestion(q);
            qf.setUserId(q.getUser().getId());
            qf.setUserName(q.getUser().getName());
            qf.setUserSurname(q.getUser().getFamilyName());
            forms.add(qf);
        }

        return forms;
    }
    @Override
    public Question findOne(Long id) {
        return questionDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        questionDao.delete(id);
    }

    @Override
    public void update(Question question) {

        questionDao.save(question);
    }
}
