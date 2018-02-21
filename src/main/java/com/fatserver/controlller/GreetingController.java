package com.fatserver.controlller;


import com.fatserver.entity.*;
import com.fatserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userServices;
    @Autowired
    private JobService jobService;
    @Autowired
    private SkillService skillService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    @Transactional
    public User greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("REQUEST!!!!!!!!!!!!!!!!!!");

       // Job job = new Job("Elecks", "2015");

        //Job job = jobService.findOne(Long.decode("2"));
        User user = userServices.findOne(Long.decode("4"));

//        job.getUserList().add(user);
//        user.getJobs().add(job);
//        jobService.save(job);
//        userServices.update(user);

//        Question question = questionService.findOne(Long.decode("6"));
//        User user = userServices.findOne(Long.decode("6"));
//        question.setUser(user);
//        user.getQuestions().add(question);
//        questionService.save(question);
//        userServices.update(user);

        return user;
    }

    @RequestMapping(value = "/index")
    public String index(){

        System.out.println("REQUEST!!!!!!!!!!!!!!!!!!");
        return "index";
    }
}
