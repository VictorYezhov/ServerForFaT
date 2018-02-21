package com.fatserver.controlller;


import com.fatserver.entity.*;
import com.fatserver.service.*;
import jdk.nashorn.internal.scripts.JO;
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
    public User greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("REQUEST!!!!!!!!!!!!!!!!!!");
        return userServices.findOne(Long.decode("1"));
    }

    @RequestMapping(value = "/index")
    public String index(){

        System.out.println("REQUEST!!!!!!!!!!!!!!!!!!");
        return "index";
    }
}
