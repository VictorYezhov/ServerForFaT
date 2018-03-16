package com.fatserver.controlller;

import com.fatserver.IncomingForms.LoginForm;
import com.fatserver.IncomingForms.RegistrationForm;
import com.fatserver.IncomingForms.UserInformationForm;
import com.fatserver.entity.Skill;
import com.fatserver.entity.User;
import com.fatserver.helpers.ImageSaver;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Victor on 11.02.2018.
 * Controller for processing requests that relate  user
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * Registration of new user
     * TODO - validation
     * @param user
     * @return
     */
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

    @PostMapping(value = "/sendUserInformation{id}")
    public String changeUserInformation(@RequestBody UserInformationForm userInformationForm, @PathVariable Long id){
        System.out.println("Number: " + userInformationForm.getNumber());
        System.out.println("City: " + userInformationForm.getCity());
        System.out.println("Id: " + id);
        User user = userService.findOne(id);
        if(!userInformationForm.getNumber().equals("")){
            user.setMobileNumber(userInformationForm.getNumber());
            userService.update(user);

        }
        if(!userInformationForm.getCity().equals("")){
            user.setAddress(userInformationForm.getCity());
            userService.update(user);

        }
        return "Information update";
    }

    /**
     * Simple login method
     * TODO Security auth. Password encription
     * @param loginForm
     * @return
     */
    @PostMapping(value = "/login")
    public User login(@RequestBody LoginForm loginForm){
        System.out.println("REQUEST_LOFINFORM");
        return   userService.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
    }

    /**
     * Method that returns skill set of user
     * @param id - user id
     * @return
     */

    @GetMapping(value = "/skills")
    public Set<Skill> getskills(@RequestParam(name = "id") String id){
        System.out.println("Accepted id "+Long.decode(id));
        return  new HashSet<>( userService.findUserWithSkills(Long.decode(id)));
    }

    /**

     Method that processes login with Google account
     */
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


    /**
     * Method used to update information about user
     * @param loginForm
     * @return
     */
    @PostMapping(value = "/updateUser")
    public User updateUser(@RequestBody LoginForm loginForm) {
        return userService.findByEmailAndPassword(loginForm.getEmail(),loginForm.getPassword());
    }

    @PostMapping(value = "/userInfo")
    public User loadUserInfo(@RequestParam Long id){

        User user = userService.findOne(id);
        user.setPassword(null);
        return user;
    }

    /**
     * Method for updating photo and storing itin file system
     * @param img
     * @param id
     * @return
     */
    @PostMapping(value = "/updatePhoto{id}")
    public String updateUserPhoto(@RequestPart(name = "img") MultipartFile img, @PathVariable String id) {
        {
            System.out.println("Request  update photo "+ id);
            User user = userService.findOne(Long.decode(id));
            ImageSaver.saveImage(user, img);
            userService.save(user);
            return "OK";
        }
    }

    /**
     * Method that returns image as byte array
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getImage{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable String id) throws IOException {
        System.err.println("GET IMAGE REQUEST "+ id);
        String filename = userService.findOne(Long.decode(id)).getPathToImage();
        if(filename ==null)
            return null;
        try {
            InputStream inputImage = new FileInputStream(filename);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int l = inputImage.read(buffer);
            while (l >= 0) {
                outputStream.write(buffer, 0, l);
                l = inputImage.read(buffer);
            }
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "image/jpg");
            return new ResponseEntity<byte[]>(outputStream.toByteArray(), headers, HttpStatus.OK);
        }catch (FileNotFoundException e){
            return null;
        }
    }


}
