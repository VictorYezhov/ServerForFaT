package com.fatserver.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Victor on 04.05.2018.
 */
@ConfigurationProperties(prefix = "fcm")
@Component
public class FCMConfig {

    private String serviceAccountFile;

    public String getServiceAccountFile() {
        return this.serviceAccountFile;
    }

    public void setServiceAccountFile(String serviceAccountFile) {
        this.serviceAccountFile = serviceAccountFile;
    }



}
