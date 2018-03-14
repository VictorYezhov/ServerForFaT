package com.fatserver.controlller;


import com.fatserver.dao.SkillDao;
import com.fatserver.entity.*;
import com.fatserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
//import sun.misc.IOUtils;

import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userServices;
    @Autowired
    private JobService jobService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;
    @Autowired
    SkillDao skillDao;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     Only used for testing
     */
    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public Country greeting(@RequestParam(value="name", defaultValue="World") String name) {


        Question question = questionService.findOne(Long.decode("1"));



        return countryService.findOne(Long.decode("1"));
    }

    @RequestMapping(value = "/index")

    public String index(){
        System.out.println("REQUEST!!!!!!!!!!!!!!!!!!");
        return "index";
    }

}






