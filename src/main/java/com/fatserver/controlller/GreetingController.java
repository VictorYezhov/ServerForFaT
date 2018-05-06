package com.fatserver.controlller;


import com.fatserver.dao.*;
import com.fatserver.entity.*;
import com.fatserver.helpers.ImageLoader;
import com.fatserver.sendingForms.CommentForm;
import com.fatserver.sendingForms.ContactDTO;
import com.fatserver.sendingForms.MessageDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    private QuestionService questionService;
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
    private JobPositionDao positionDao;
    @Autowired
    SkillDao skillDao;
    @Autowired
    CommentDao commentDao;
    @Autowired
    ContactService contactService;

    @Autowired
    MessageDao messageDao;

    private NotificationSender notificationSender;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public GreetingController(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    /**
     Only used for testing
     */
    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public List<MessageDTO> greeting(@RequestParam(value="name", defaultValue="World") String name) {


        List<Message> commentForms = messageDao.findAll();

        List<MessageDTO> mDTOS = new ArrayList<>();

        for(Message c:commentForms){
            mDTOS.add(new MessageDTO(c));
        }

//        User usetTo = userServices.findOne(1L);
//        User userFrom = userServices.findOne(2L);
//        notificationSender.sendNotification(userFrom,usetTo);


        return mDTOS;
    }

    @RequestMapping(value = "/index")

    public String index(){
        System.out.println("REQUEST!!!!!!!!!!!!!!!!!!");
        return "index";
    }

}






