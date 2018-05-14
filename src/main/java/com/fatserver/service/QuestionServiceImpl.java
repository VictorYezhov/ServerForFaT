package com.fatserver.service;

import com.fatserver.dao.CategoryDao;
import com.fatserver.dao.QuestionDao;
import com.fatserver.entity.Category;
import com.fatserver.entity.Question;
import com.fatserver.sendingForms.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 19.02.2018.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public void save(Question question) {
        questionDao.save(question);
    }

    @Override
    public List<QuestionDTO> findAll() {
        List<Question> questions =  questionDao.findAll();

        return formDtos(questions);
    }


    @Override
    public List<QuestionDTO> findAllByCategoty(Long categoryId) {

        List<Question> questions = questionDao.findQuestionsByCategory(categoryDao.findOne(categoryId));


        return formDtos(questions);
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

    private List<QuestionDTO> formDtos(List<Question> questions){
        List<QuestionDTO> forms = new ArrayList<>();
        QuestionDTO qf;
        for (Question q: questions ) {
            qf = new QuestionDTO();
            qf.setQuestion(q);
            qf.setUserId(q.getUser().getId());
            qf.setUserName(q.getUser().getName());
            qf.setUserSurname(q.getUser().getFamilyName());
            forms.add(qf);
        }
        return forms;
    }
}
