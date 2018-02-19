package com.fatserver.controlller;

import com.fatserver.IncomingForms.LoginForm;
import com.fatserver.IncomingForms.RegistrationForm;
import com.fatserver.entity.Skill;
import com.fatserver.entity.User;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.Set;

/**
 * Created by Victor on 11.02.2018.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping(value = "/user/add")
    public User addUser(@RequestBody RegistrationForm user){
        System.out.println("REQUEST");
        if(userService.findByName(user.getName())!=null){
            return new User(user);
        }else {
            User u = new User(user);
            userService.save(u);
            return u;
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

    @PostMapping(value = "/googleLogin")
    public User getGoogleUser(@RequestBody RegistrationForm googleUser){
        System.out.println("REQUEST_GOOGLE_LOGIN");
        User foundUser = userService.findByEmailAndPassword(googleUser.getEmail(), googleUser.getPassword());
        if(foundUser != null){
            return foundUser;
        }else {
            User u = new User(googleUser);
            userService.save(u);
            return u;

        }
    }



}
