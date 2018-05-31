package com.fatserver.service;

import com.fatserver.dao.CategoryDao;
import com.fatserver.dao.QuestionDao;
import com.fatserver.dto.QuestionDTO;
import com.fatserver.entity.Question;
import com.fatserver.dto.SendQuestionDTO;
import com.fatserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
    public List<SendQuestionDTO> findAll() {
        List<Question> questions =  questionDao.findAll();

        return formDtos(questions);
    }


    @Override
    public List<SendQuestionDTO> findAllByCategoty(Long categoryId) {

        List<Question> questions = questionDao.findQuestionsByCategory(categoryDao.findOne(categoryId));


        return formDtos(questions);
    }

    @Override
    public Question findQuestionByDateTimeAndUser(Timestamp time, User user) {
        return questionDao.findQuestionByDateTimeAndUser(time, user);
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

    private List<SendQuestionDTO> formDtos(List<Question> questions){
        List<SendQuestionDTO> forms = new ArrayList<>();
        SendQuestionDTO qf;
        QuestionDTO  questionDTO;
        for (Question q: questions ) {
            qf = new SendQuestionDTO();
            questionDTO = new QuestionDTO(q);
            qf.setQuestion(questionDTO);
            qf.setUserId(q.getUser().getId());
            qf.setUserName(q.getUser().getName());
            qf.setUserSurname(q.getUser().getFamilyName());
            forms.add(qf);
        }
        return forms;
    }
}
