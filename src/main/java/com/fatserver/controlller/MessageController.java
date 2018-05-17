package com.fatserver.controlller;


import com.fatserver.entity.Contact;
import com.fatserver.entity.Message;
import com.fatserver.entity.User;
import com.fatserver.dto.ContactDTO;
import com.fatserver.dto.MessageDTO;
import com.fatserver.service.ContactService;
import com.fatserver.service.MessageService;
import com.fatserver.service.NotificationSender;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Timestamp;
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

    private BigInteger  b = new BigInteger("1");
    private NotificationSender notificationSender;


    public MessageController(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    //TODO messaging service between users
    @RequestMapping(value = "/getMessages{id}", method= RequestMethod.POST)
    public List<MessageDTO> greeting(@PathVariable("id") Long id, @RequestParam("userId") Long requester) {
        System.out.println("GET MESSAGES REQUESt");
        Contact contact = contactService.findOne(id);
        List<Message> messages = messageService.findAllByContact(contact);



        System.out.println(messages.size());
        List<MessageDTO> mDTOS = new ArrayList<>();
       // MessageDTO message;
        for(Message c: messages){
           // message = new MessageDTO(c);
            if(c.getFrom().getId().equals(requester))
                continue;
            c.setRead(true);
            mDTOS.add(new MessageDTO(c));
            messageService.update(c);
        }
        return mDTOS;
    }

    @RequestMapping(value = "/getAllMessages{id}", method= RequestMethod.POST)
    public List<MessageDTO> getAllMessages(@PathVariable("id") Long id,@RequestParam("userId") Long requester) {

        List<Message> messages = messageService.findAllForContact(contactService.findOne(id));
        System.out.println(messages.size());
        List<MessageDTO> mDTOS = new ArrayList<>();
        // MessageDTO message;
        for(Message c: messages){
            // message = new MessageDTO(c);
            if(c.getFrom().getId().equals(requester))
                continue;
            c.setRead(true);
            mDTOS.add(new MessageDTO(c));
            messageService.update(c);
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
            contactDTO = new ContactDTO(c, findUserFrom(requester, c));
             if(lastMessage!=null) {
                 contactDTO.setLastMessageText(lastMessage.getMessage());
                 contactDTO.setTimestamp(lastMessage.getTimestamp());
             }else {
                 contactDTO.setLastMessageText("start conversation");
                 contactDTO.setTimestamp(new Timestamp(System.currentTimeMillis()));
             }
            contactDTOS.add(contactDTO);
        }

        return contactDTOS;

    }

    @PostMapping("/sendMessage")
    public String acceptMessage(@RequestBody MessageDTO messageDTO){


        Contact contact = contactService.findOne(messageDTO.getContactId());
        User sender = userService.findOne(messageDTO.getFrom());
        Message message = new Message();
        message.setFrom(sender);
        message.setContact(contact);
        message.setColor(0);
        message.setMessage(messageDTO.getMessage());
        message.setRead(false);
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        messageService.save(message);

        User getter;
        if(sender.getId() == contact.getSide1().getId()){
            getter = contact.getSide2();
        }else {
            getter = contact.getSide1();
        }
        notificationSender.sendNotification(contact, getter);


        return "OK";
    }

    @PostMapping("/createNewChat")
    public String createNewChat(@RequestParam("side1") Long side1, @RequestParam("side2") Long side2){
        if(contactService.checkIfContactExists(side1,side2).equals(b)){
            return String.valueOf(contactService.findContactBySides(side1,side2).getId());
        }

        Contact newContact = new Contact();
        newContact.setSide1(userService.findOne(side1));
        newContact.setSide2(userService.findOne(side2));
        contactService.save(newContact);

        return String.valueOf(contactService.findContactBySides(side1,side2).getId());
    }


    private User findUserFrom(User requester, Contact contact){
        if(requester.getId().equals(contact.getSide1().getId())){
            return contact.getSide2();
        }else {
            return contact.getSide1();
        }
    }








}
