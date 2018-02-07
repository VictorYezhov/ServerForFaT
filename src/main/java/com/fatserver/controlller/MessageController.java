package com.fatserver.controlller;

import com.fatserver.entity.Greeting;
import com.fatserver.entity.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 07.02.2018.
 */
@RestController
public class MessageController {



    private List<Message> messages =  new ArrayList<>();

    @RequestMapping(value = "/getMessages", method= RequestMethod.GET)
    public List<Message> greeting() {
        messages.clear();


        addData();
        System.out.println("REQUEST!!!!!!!!!!!!!!!!!!");
        return messages;
    }

    private void addData(){
        messages.add(new Message(1, "Victor Yezhov","Find a tutor", "hello_2", "9:07", "xcvxc", true, false));

        messages.add(new Message(2, "Vasiliy Goh","Find a tutor", "hello_3", "9:07", "xcvxc", true, false));
        messages.add(new Message(3, "Misha Yaponchik","Kill", "hello_4", "10:07", "xcvxc", true, false));
        messages.add(new Message(4, "Oles Dobosevych","Lerning", "hello_5", "11:07", "xcvxc", true, false));
        messages.add(new Message(5, "Sofia Rak","Logic", "hello_6", "12:07", "xcvxc", true, false));
        messages.add(new Message(6, "Arsen Graz","Smoking", "hello_7", "13:07", "xcvxc", true, false));
        messages.add(new Message(7, "Sasha Sharomov","AGROO", "hello_8", "14:07", "xcvxc", true, false));
        messages.add(new Message(8, "Tolik Nod","Pidr", "hello_9", "15:07", "xcvxc", true, false));



    }




}
