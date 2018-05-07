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

import java.math.BigInteger;
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

    private BigInteger b = new BigInteger("1");

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

        Message lastMessage;
        ContactDTO contactDTO;
        List<ContactDTO> contactDTOS = new ArrayList<>();
        for(Contact c: contacts){
             lastMessage = messageService.findLastMessageForContact(c);
              contactDTO = new ContactDTO(c, findUserFrom(requester,c));
              contactDTO.setLastMessageText(lastMessage.getMessage());
              contactDTO.setTimestamp(lastMessage.getTimestamp());
            contactDTOS.add(contactDTO);
        }

        return contactDTOS;

    }

    @PostMapping("/createNewChat")
    public String createNewChat(@RequestParam("side1") Long side1, @RequestParam("side2") Long side2){
        if(contactService.checkIfContactExists(side1,side2).equals(b)){
            return "OK";

        }

        Contact newContact = new Contact();
        newContact.setSide1(userService.findOne(side1));
        newContact.setSide2(userService.findOne(side2));
        contactService.save(newContact);


        return "OK";
    }


    private User findUserFrom(User requester, Contact contact){
        if(requester.getId().equals(contact.getSide1().getId())){
            return contact.getSide2();
        }else {
            return contact.getSide1();
        }
    }








}
