package com.fatserver.controlller;

import com.fatserver.dto.QuestionDTO;
import com.fatserver.dto.SkillDTO;
import com.fatserver.comparators.DateComparator;
import com.fatserver.entity.Category;
import com.fatserver.entity.Question;
import com.fatserver.entity.Skill;
import com.fatserver.entity.User;
import com.fatserver.dto.SendQuestionDTO;
import com.fatserver.service.CategotyService;
import com.fatserver.service.QuestionService;
import com.fatserver.service.SkillService;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Autowired
    CategotyService categotyService;



    /**
     * Method returns all questions available in DB
     * @return
     */

    @GetMapping("/getAllQuestions")//TODO : Filltring and sending only latest questions
    public List<SendQuestionDTO> getAllQuestions(){
        List<SendQuestionDTO> questionDTOS = questionService.findAll();

        Collections.sort(questionDTOS, new DateComparator());
        return questionDTOS;
    }

    @GetMapping("/getQuestionsByCategory{id}")
    public List<SendQuestionDTO> getQuestionsByCategory(@PathVariable("id") Long id){
        List<SendQuestionDTO> questionDTOS = questionService.findAllByCategoty(id);
        Collections.sort(questionDTOS, new DateComparator());
        return questionDTOS;
    }

    @PostMapping(value = "/sendAskingQuestion{id}")
    public String askQuestion(@RequestBody com.fatserver.dto.QuestionDTO question, @PathVariable Long id){

        Question questionToSave = new Question(question);
        Long iid = question.getCategory().getId();
        Category category = categotyService.findOne(iid);
        questionToSave.setCategory(category);
        User user = userService.findOne(id);
        Skill skill = null;
        for (SkillDTO s:question.getSkills()) {
            skill = skillService.findByName(s.getName());
            questionToSave.getSkills().add(skill);
            skill.getQuestionList().add(questionToSave);

        }
        questionToSave.setUser(user);
        questionToSave.setDateTime(new Timestamp(System.currentTimeMillis()));
        user.getQuestions().add(questionToSave);
        questionService.save(questionToSave);
        skillService.save(skill);


        return "OK";
    }

    @GetMapping(value = "/getAllUsersQuestions{id}")
    public List<QuestionDTO> sendToClientAllUsersQuestions(@PathVariable Long id){
        List<SendQuestionDTO> questionForms = questionService.findAll();
        List<QuestionDTO> userQuestions = new ArrayList<>();


        for (SendQuestionDTO questionForm: questionForms){
            if(questionForm.getUserId().equals(id)){

                userQuestions.add(questionForm.getQuestion());
            }
        }
        return userQuestions;
    }

    @GetMapping("/getQuestionTitle{id}")
    public String getQuestionTitle(@PathVariable("id") Long id){
        String s = questionService.findOne(id).getTitle();
        return s.replaceAll("\\s", "@");
    }

    @PostMapping(value = "/plusOneToViewCounter{id}")
    public String plusOneToViewCounter(@PathVariable Long id){

        Question q = questionService.findOne(id);
        q.setViews(q.getViews() + 1);
        questionService.update(q);

        return "OK";
    }
}
