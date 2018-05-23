package com.fatserver.controlller;


import com.fatserver.dao.*;
import com.fatserver.entity.*;
import com.fatserver.dto.MessageDTO;

import com.fatserver.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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


//        name = "c.xls";
//        InputStream in = null;
//        HSSFWorkbook wb = null;
//        List<Country> las = new ArrayList<>();
//        try {
//            in = new FileInputStream(name);
//            wb = new HSSFWorkbook(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Sheet sheet = wb.getSheetAt(0);
//        Iterator<Row> it = sheet.iterator();
//        Country country;
//        while (it.hasNext()) {
//            country = new Country();
//            Row row = it.next();
//            Iterator<Cell> cells = row.iterator();
//            while (cells.hasNext()) {
//                Cell cell = cells.next();
//                if(!cell.getStringCellValue().equals("")){
//                    country.setName(cell.getStringCellValue());
//                }
//                if(cells.hasNext()) {
//                    cell = cells.next();
//                    if(!cell.getStringCellValue().equals("")) {
//                        country.setCode(cell.getStringCellValue());
//                        las.add(country);
//                        countryService.save(country);
//                        System.out.println("country : " + country.getName() + " code : " + country.getCode());
//                    }
//                }
//            }
//        }
//        Contact contact =  contactService.findContactBySides(usetTo.getId(), userFrom.getId());
        //notificationSender.sendNotificationAboutPersonalMessage(contact,usetTo);


        return null;
    }

    @RequestMapping(value = "/index")

    public String index(){
        System.out.println("REQUEST!!!!!!!!!!!!!!!!!!");
        return "index";
    }

}






