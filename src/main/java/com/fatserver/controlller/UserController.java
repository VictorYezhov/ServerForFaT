package com.fatserver.controlller;

import com.fatserver.entity.LoginForm;
import com.fatserver.entity.User;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Victor on 11.02.2018.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

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
        return  userService.findByEmailAndPassword(loginForm.getEmail(),loginForm.getPassword());
    }



}
