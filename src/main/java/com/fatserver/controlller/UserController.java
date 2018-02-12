package com.fatserver.controlller;

import com.fatserver.dao.UserDao;
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


//    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
//    public User addUser(@RequestParam(value = "name",defaultValue = "user") String name
//            , @RequestParam(value = "email", defaultValue = "email@gg.com") String email
//            ,@RequestParam(value = "password",defaultValue = "password") String password
//            ,@RequestParam(value = "familyName",defaultValue = "familyName") String familyName
//            ,@RequestParam(value ="rating",defaultValue = "5") String rating
//            ,@RequestParam(value = "address",defaultValue = "addres")String address){
//
//
//        User user = new User();
//
//        System.out.println("REQUEST");
//        user.setName(name);
//        user.setEmail(email);
//        user.setFamilyName(familyName);
//        user.setPassword(password);
//        user.setRating(Integer.parseInt(rating));
//        if(userDao.findByName(user.getName())!=null){
//            return user;
//        }else {
//        userDao.save(user);
//        return user;
//        }
//    }
//    @RequestMapping(value = "/simplepost", method = RequestMethod.POST)
//    public String simplePost(){
//
//
//        System.out.println("REQUEST");
//        return "simplePost";
//    }

    @PostMapping(value = "/user/add")
    public User addUser(@RequestBody User user){
        System.out.println("REQUEST");
        System.out.println(user.getAddress());
        if(userDao.findByName(user.getName())!=null){
            return user;
        }else {
            userDao.save(user);
            return user;
        }
    }




}
