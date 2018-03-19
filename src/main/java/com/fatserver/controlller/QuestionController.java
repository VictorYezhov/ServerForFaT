package com.fatserver.controlller;

import com.fatserver.IncomingForms.IncomingQuestion;
import com.fatserver.IncomingForms.IncomingSkill;
import com.fatserver.comparators.DateComparator;
import com.fatserver.entity.Question;
import com.fatserver.entity.Skill;
import com.fatserver.entity.User;
import com.fatserver.sendingForms.QuestionForm;
import com.fatserver.service.QuestionService;
import com.fatserver.service.SkillService;
import com.fatserver.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Victor on 06.03.2018.
 * Controller that processes requests for questions
 */

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;
    @Autowired
    SkillService skillService;


    /**
     * Method returns all questions available in DB
     * @return
     */

    @GetMapping("/getAllQuestions")//TODO : Filltring and sending only latest questions
    public List<QuestionForm> getAllQuestions(){
        List<QuestionForm> questionForms = questionService.findAll();
        Collections.sort(questionForms, new DateComparator());
        return questionForms;
    }

    @PostMapping(value = "/sendAskingQuestion{id}")
    public String askQuestion(@RequestBody IncomingQuestion question, @PathVariable Long id){
        System.out.println("Question: " + question.getTitle());
        Question questionToSave = new Question(question);
        User user = userService.findOne(id);
        Skill skill;
        for (IncomingSkill s:question.getSkills()) {
            skill = skillService.findOne(s.getId());
            questionToSave.getSkills().add(skill);
        }
        questionToSave.setUser(user);
        questionToSave.setDateTime(new Timestamp(System.currentTimeMillis()));
        user.getQuestions().add(questionToSave);
        questionService.save(questionToSave);

        return "OK";
    }
}
