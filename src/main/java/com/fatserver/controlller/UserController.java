package com.fatserver.controlller;

import com.fatserver.entity.LoginForm;
import com.fatserver.entity.Skill;
import com.fatserver.entity.User;
import com.fatserver.service.SkillService;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Victor on 11.02.2018.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SkillService skillService;

    @PostMapping(value = "/user/add")
    public User addUser(@RequestBody User user){
        System.out.println("REQUEST");
        if(userService.findByName(user.getName())!=null){
            return user;
        }else {
            userService.save(user);
            return user;
        }
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody LoginForm loginForm){
        System.out.println("REQUEST_LOFINFORM");
        return   userService.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
    }


    @GetMapping(value = "/skills")
    public Set<Skill> getskills(@RequestParam(name = "id") String id){
        System.out.println("Accepted id "+Long.decode(id));

        return  userService.findUserWithSkills(Long.decode(id)).getSkills();

    }



}
