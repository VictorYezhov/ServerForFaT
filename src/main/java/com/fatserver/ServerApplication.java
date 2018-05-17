package com.fatserver;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		//GCMNotificationSender gcmNotificationSender = GCMNotificationSender.getInstance();
		//System.out.println(gcmNotificationSender.sendNotificationAboutPersonalMessage("1","gfgfgh"));
		//eYCiLWf-jAk:APA91bHJNUPLnntNj5OHlIaNzpV1wrEOF8mpolIhxQqKbsJlBN9uPvJmmr_J5NqoU0a76oJC1Rm0aCDdLvyie3vsLA-0ExgV2JszMLUi3EaIdgA7CeFiJR0pIaInLSAG2M7QVR-MY78i
		SpringApplication.run(ServerApplication.class, args);

	}
}
