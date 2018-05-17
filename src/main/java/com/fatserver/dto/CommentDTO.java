package com.fatserver.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fatserver.entity.Comment;
import com.fatserver.helpers.JsonDateSerializer;

import java.sql.Timestamp;

/**
 * Created by Victor on 17.05.2018.
 */
public class CommentDTO {


    private Long id;
    private String textComment;
    private Integer price;
    private Long userId;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Timestamp dateTime;
    private QuestionDTO question;


    public CommentDTO() {
    }

    public CommentDTO(Comment c) {
        id = c.getId();
        textComment = c.getTextComment();
        price = c.getPrice();
        userId = c.getUserId();
        dateTime = c.getDateTime();
        question = new QuestionDTO(c.getQuestion_com());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }
}
