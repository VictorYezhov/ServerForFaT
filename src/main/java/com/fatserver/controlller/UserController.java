package com.fatserver.controlller;

import com.fatserver.dao.UserDao;
import com.fatserver.entity.LoginForm;
import com.fatserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Victor on 11.02.2018.
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping(value = "/user/add")
    public User addUser(@RequestBody User user){
        System.out.println("REQUEST");
        if(userDao.findByName(user.getName())!=null){
            return user;
        }else {
            userDao.save(user);
            return user;
        }
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody LoginForm loginForm){
        System.out.println("REQUEST_LOFINFORM");
        return  userDao.findByEmailAndPassword(loginForm.getEmail(),loginForm.getPassword());
    }



}
