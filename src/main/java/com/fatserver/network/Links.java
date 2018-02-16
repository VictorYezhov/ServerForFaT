package com.fatserver.network;

import java.util.Arrays;

/**
 * Created by Victor on 07.02.2018.
 */
public enum Links {
    BASE("/"),  GETMESSAGE("/getMessages"),HOME("/home"),SAVEUSER("/user/add"),
    SKILLS("/skills");

    private String link;

    Links(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public static String[] getValues(){

       String values[]=new String[Links.values().length];
       int i =0;

        for (Links link:
             Links.values()) {
            values[i] = link.getLink();
            i++;
        }

        return values;


    }
}
