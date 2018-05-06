package com.fatserver.controlller;


import com.fatserver.dao.MessageDao;
import com.fatserver.entity.Contact;
import com.fatserver.entity.Message;
import com.fatserver.entity.User;
import com.fatserver.sendingForms.ContactDTO;
import com.fatserver.sendingForms.MessageDTO;
import com.fatserver.service.ContactService;
import com.fatserver.service.MessageService;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 07.02.2018.
 */
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;
    @Autowired
    private ContactService contactService;

    //TODO messaging service between users
    @RequestMapping(value = "/getMessages{id}", method= RequestMethod.GET)
    public List<MessageDTO> greeting(@PathVariable("id") Long id) {
        System.out.println("GET MESSAGES REQUESt");
        List<Message> messages = messageService.findAllByContact(contactService.findOne(id));

        List<MessageDTO> mDTOS = new ArrayList<>();

       // MessageDTO message;
        for(Message c: messages){
           // message = new MessageDTO(c);
            mDTOS.add(new MessageDTO(c));
        }
        return mDTOS;
    }

    @PostMapping(value = "/getMyContacts")
    public List<ContactDTO> getContactsOfUser(@RequestParam("id") Long id){

        User requester = userService.findOne(id);
        List<Contact> contacts = contactService.findContactForUser(requester);

        List<ContactDTO> contactDTOS = new ArrayList<>();
        for(Contact c: contacts){
            contactDTOS.add(new ContactDTO(c, findUserFrom(requester,c)));
        }

        return contactDTOS;

    }


    private User findUserFrom(User requester, Contact contact){
        if(requester.getId().equals(contact.getSide1().getId())){
            return contact.getSide2();
        }else {
            return contact.getSide1();
        }
    }








}
