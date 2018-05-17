package com.fatserver.dto;

import com.fatserver.entity.Question;

/**
 * Created by Victor on 06.03.2018.
 * Container for sending information about question
 */
public class SendQuestionDTO {

    private QuestionDTO question;
    private Long userId;
    private String userName;
    private String userSurname;

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

