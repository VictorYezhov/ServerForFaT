package com.fatserver.controlller;

import com.fatserver.entity.Question;
import com.fatserver.entity.User;
import com.fatserver.sendingForms.QuestionForm;
import com.fatserver.service.QuestionService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

/**
 * Created by Victor on 06.03.2018.
 */
@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;



    @GetMapping("/getAllQuestions")//TODO : Filltring and sending only latest questions
    public List<QuestionForm> getAllQuestions(){
        return questionService.findAll();
    }

}
