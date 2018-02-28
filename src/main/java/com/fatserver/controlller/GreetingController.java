package com.fatserver.controlller;


import com.fatserver.entity.*;
import com.fatserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sun.misc.IOUtils;

import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding;
import java.awt.image.BufferedImage;
import java.io.*;
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
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public Properties greeting(@RequestParam(value="name", defaultValue="World") String name) {

        User user = userServices.findOne(Long.decode("1"));
        File file = new File(user.getPathToImage());
        System.out.println(file.exists());
        return System.getProperties();
    }

    @RequestMapping(value = "/index")

    public String index(){
        System.out.println("REQUEST!!!!!!!!!!!!!!!!!!");
        return "index";
    }
    @RequestMapping("/getImage{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) throws IOException {
        String filename = userServices.findOne(Long.decode(id)).getPathToImage();
        InputStream inputImage = new FileInputStream(filename);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int l = inputImage.read(buffer);
        while(l >= 0) {
            outputStream.write(buffer, 0, l);
            l = inputImage.read(buffer);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "image/jpg");
        return new ResponseEntity<byte[]>(outputStream.toByteArray(), headers, HttpStatus.OK);
    }
}






