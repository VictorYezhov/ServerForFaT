package com.fatserver.helpers;

import com.fatserver.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Victor on 20.02.2018.
 */
public class ImageSaver {

    public static void saveImage(User user, MultipartFile image) {

        String path = System.getProperty("catalina.home") + "/resources/Users/"
                + user.getName() + "/" + image.getOriginalFilename();
        user.setPathToImage("resources/Users/" + user.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

    }

}
