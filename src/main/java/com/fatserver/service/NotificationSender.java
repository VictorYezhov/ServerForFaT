package com.fatserver.service;

import com.fatserver.entity.Contact;
import com.fatserver.entity.User;
import com.fatserver.network.NotificationType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Victor on 05.05.2018.
 */
@Service
public class NotificationSender {

    private final  FCMService fcmService;

    public NotificationSender(FCMService fcmService) {
        this.fcmService = fcmService;
    }

    public void sendNotificationAboutPersonalMessage(Contact contact, User userTo){

        try {
            this.fcmService.sendPersonalMessage(userTo.getGcmRegId(), contact.getId().toString(),
                    NotificationType.PERSONALMESSAGE);
        }
        catch (InterruptedException | ExecutionException e) {
            System.err.println("send personal message\n"+ e);
        }
    }

    public void sendNotificationAboutNewContract(User from, User userTo){
        try {
            this.fcmService.sendPersonalMessage(userTo.getGcmRegId(), from.getId().toString(),
                    NotificationType.NEWCONTRACT);
        }
        catch (InterruptedException | ExecutionException e) {
            System.err.println("send personal message\n"+ e);
        }
    }
}
