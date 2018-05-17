package com.fatserver.dto;

import com.fatserver.entity.Comment;

/**
 * Created by Victor on 22.03.2018.
 */
public class CommentForm {

    private CommentDTO comment;
    private String userName;
    private String userSurname;
    //byte[] image;


    public CommentDTO getComment() {
        return comment;
    }

    public void setComment(CommentDTO comment) {
        this.comment = comment;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
}
