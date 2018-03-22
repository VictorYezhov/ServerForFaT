package com.fatserver.helpers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.*;

/**
 * Created by Victor on 22.03.2018.
 */
public class ImageLoader {


    public static ResponseEntity<byte[]> loadImageFromFileSystem(String filename){
        if(filename ==null)
            return null;
        try {
            InputStream inputImage = new FileInputStream(filename);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int l = inputImage.read(buffer);
            while (l >= 0) {
                outputStream.write(buffer, 0, l);
                l = inputImage.read(buffer);
            }
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "image/jpg");
            return new ResponseEntity<byte[]>(outputStream.toByteArray(), headers, HttpStatus.OK);
        }catch (FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
            return null;
        }catch (IOException e){
            System.out.println("IOEXCEPTION");
            return null;
        }
    }
}
