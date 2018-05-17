package com.fatserver.service;

import com.fatserver.configuration.FCMConfig;
import com.fatserver.network.NotificationType;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Victor on 04.05.2018.
 */
@Service
public class FCMService {


    public FCMService(FCMConfig settings) {
        Path p = Paths.get(settings.getServiceAccountFile());
        try (InputStream serviceAccount = Files.newInputStream(p)) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            System.err.println("ERROR DURING FIREBASE INIT");
        }

    }


    public void sendPersonalMessage(String clientToken, String from, NotificationType notificationType)
            throws InterruptedException, ExecutionException {
        AndroidConfig androidConfig = AndroidConfig.builder()
                .setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey("personal")
                .setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(AndroidNotification.builder().setTag("personal").build())
                .build();


        ApnsConfig apnsConfig = ApnsConfig.builder()
                .setAps(Aps.builder().setCategory("personal").setThreadId("personal").build())
                .build();

        Message message = Message.builder().setToken(clientToken)
                .putData("type", notificationType.getType())
                .setApnsConfig(apnsConfig).setAndroidConfig(androidConfig)
                .setNotification(new Notification("Personal Message", from))
                .build();

        String response = FirebaseMessaging.getInstance().sendAsync(message).get();
        System.out.println("Sent message: " + response);
    }





}
