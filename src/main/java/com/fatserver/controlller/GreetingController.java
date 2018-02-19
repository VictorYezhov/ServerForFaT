package com.fatserver.controlller;


import com.fatserver.entity.Greeting;
import com.fatserver.entity.Skill;
import com.fatserver.entity.User;
import com.fatserver.service.SkillService;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    private SkillService skillService;
    @Autowired
    private UserService userService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    @Transactional
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("REQUEST!!!!!!!!!!!!!!!!!!");

        User user = userService.findUserWithSkills(Long.decode("9"));

        for (Skill s:
             user.getSkills()) {
            System.out.println(s.getName());
        }

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/index")
    public String index(){

        System.out.println("REQUEST!!!!!!!!!!!!!!!!!!");
        return "index";
    }
}
