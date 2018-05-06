package com.fatserver.controlller;


import com.fatserver.IncomingForms.SkillDTO;
import com.fatserver.IncomingForms.SendSkillsForm;
import com.fatserver.entity.Skill;
import com.fatserver.entity.User;
import com.fatserver.service.SkillService;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Victor on 17.02.2018.
 * Controller for processing requests that relate to the skills set of user
 */
@RestController
public class SkillController {

    @Autowired
    UserService userService;

    @Autowired
    SkillService skillService;

    /**
     * Method returns all available skills from DB
     * @return
     */
    @GetMapping(value = "/getAllSkills")
    public List<Skill> getAlSkills(){
        return  skillService.findAll();
    }

    /**
     * Add new skills to user
     * @param skills - skills to add to user, and user id
     * @return
     */
    @PostMapping(value = "/sendNewSkills")
    public String saveNewSkills(@RequestBody SendSkillsForm skills){

        User user = userService.findOne(skills.getUserId());
        Skill skill;
        System.out.println("SKILLS: ");
        for (SkillDTO s:
             skills.getSkills()) {
            System.out.println(s.getId()+" "+s.getName());
            skill = skillService.findOne(s.getId());
            user.getSkills().add(skillService.findOne(s.getId()));
            skill.getUserList().add(user);
            skillService.save(skill);
        }
        for (Skill s:
             user.getSkills()) {
            System.out.println(s.getName()+" "+ s.getId());
        }
        userService.update(user);
        return "OK";
    }




}
