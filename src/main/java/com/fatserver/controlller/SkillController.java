package com.fatserver.controlller;


import com.fatserver.entity.Skill;
import com.fatserver.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by Victor on 17.02.2018.
 */
@RestController
public class SkillController {


    @Autowired
    SkillService skillService;

    @GetMapping(value = "/getAllSkills")
    public List<Skill> getAlSkills(){
        return  skillService.findAll();
    }




}
