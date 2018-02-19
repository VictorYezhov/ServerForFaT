package com.fatserver.service;

import com.fatserver.dao.QuestionDao;
import com.fatserver.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Question> findAll() {
        return questionDao.findAll();
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
