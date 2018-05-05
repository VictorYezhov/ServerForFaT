package com.fatserver.service;

import com.fatserver.entity.User;
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

    public void sendNotification(User userFrom, User userTo){



        try {
            this.fcmService.sendPersonalMessage(userTo.getGcmRegId(), userFrom.getId().toString());
        }
        catch (InterruptedException | ExecutionException e) {
            System.err.println("send personal message\n"+ e);
        }




    }
}
