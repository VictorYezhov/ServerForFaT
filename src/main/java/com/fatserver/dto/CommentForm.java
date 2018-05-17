package com.fatserver.dto;

import com.fatserver.entity.Comment;

/**
 * Created by Victor on 22.03.2018.
 */
public class CommentForm {

    private Comment comment;
    private String userName;
    private String userSurname;
    //byte[] image;


    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }

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
