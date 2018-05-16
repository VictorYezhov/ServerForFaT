package com.fatserver.controlller;

import com.fatserver.IncomingForms.*;
import com.fatserver.entity.*;
import com.fatserver.helpers.ImageLoader;
import com.fatserver.helpers.ImageSaver;
import com.fatserver.service.CityService;
import com.fatserver.service.CountryService;
import com.fatserver.service.ReviewService;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Victor on 11.02.2018.
 * Controller for processing requests that relate  user
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @Autowired
    private ReviewService reviewService;


    /**
     * Registration of new user
     * TODO - validation
     * @param user
     * @return
     */
    @PostMapping(value = "/user/add")
    public User addUser(@RequestBody RegistrationForm user){
        System.out.println("Registration request");
        Country country = countryService.findCountryByName(user.getCity().getCountry().getName());
        City city;


        if(userService.findByName(user.getName())!=null){
            return new User(user);
        }else {
            User newUser = new User(user);
            if(country != null){
                city = cityService.findCityByName(user.getCity().getName(), country.getId());
                if( city != null){
                    newUser.setCity(city);
                }else {
                    city = new City();
                    city.setName(user.getCity().getName());
                    city.setCountry(country);
                    newUser.setCity(city);
                    cityService.save(city);
                }
            }else {
                return null;
            }
            userService.save(newUser);
            return newUser;
        }






    }

    @PostMapping(value = "/sendUserInformation{id}")
    public String changeUserInformation(@RequestBody UserInformationForm userInformationForm, @PathVariable Long id){


        User user = userService.findOne(id);
        if(!userInformationForm.getNumber().equals("")){
            user.setMobileNumber(userInformationForm.getNumber());
            userService.update(user);
        }
        Country country  = countryService.findCountryByName(userInformationForm.getCountry());
        System.out.println(country.getName());
        if(country != null){
            City city = cityService.findCityByName(userInformationForm.getCity(), country.getId());
            if( city != null){
                user.setCity(city);
                userService.update(user);
            }else {
                city = new City();
                city.setName(userInformationForm.getCity());
                city.setCountry(country);
                user.setCity(city);
                System.out.println(city.getName());
                cityService.save(city);
                userService.update(user);
            }
        }else {
            return "Enter valid country";
        }


        return "Information updated";
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
       return ImageLoader.loadImageFromFileSystem(filename);
    }

    @PostMapping("/updateFCMIdToken")
    public String updateFcmIdToken(@RequestParam("user_id") Long userId, @RequestParam("token") String token){

        System.out.println("USER ID"+userId);
        System.out.println("TOKEN "+ token);

        User user = userService.findOne(userId);
        user.setGcmRegId(token);
        userService.update(user);

        return "OK";
    }



    @GetMapping("/getReviews{id}")
    public List<ReviewDTO> getReviewsForUser(@PathVariable("id") Long id){

        List<Review> reviews = reviewService.findAllReviewAboutUser(userService.findOne(id));

        List<ReviewDTO> reviewDTOS = new ArrayList<>();

        for(Review r: reviews){
            reviewDTOS.add(new ReviewDTO(r));
        }
        return reviewDTOS;
    }

    @GetMapping("/getReviewsAndRating{id}")
    public RatingReviewsDTO getReviewsAndRatingAboutUser(@PathVariable("id") Long id){

        RatingReviewsDTO ratingReviewsDTO = new RatingReviewsDTO();

        User user = userService.findOne(id);
        List<Review> reviews = reviewService.findAllReviewAboutUser(user);

        ratingReviewsDTO.setRating(user.getRating());
        for(Review r: reviews){
            ratingReviewsDTO.getReviews().add(new ReviewDTO(r));
        }
        return ratingReviewsDTO;
    }


}
