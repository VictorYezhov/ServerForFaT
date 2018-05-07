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
import java.util.Set;

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

    @PostMapping(value = "/deleteItemFromChipList{id}")
    public  String deleteAccountChip(@RequestBody Long user_id, @PathVariable Long id){
        User user = userService.findOne(user_id);
        Set<Skill> user_skill_list = user.getSkills();
        Skill skill = skillService.findOne(id);

        //----------WHY??????--------------
        System.out.println(skill.getName() + " " + skill.getId());


        user_skill_list.remove(skill);
        user.setSkills(user_skill_list);
        userService.update(user);

        Set<User> skill_users_list = skill.getUserList();
        skill_users_list.remove(user);
        skill.setUserList(skill_users_list);
        skillService.update(skill);
        return "OK";
    }




}
