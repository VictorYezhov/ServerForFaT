package com.fatserver.sendingForms;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fatserver.entity.Contact;
import com.fatserver.entity.Message;
import com.fatserver.entity.User;
import com.fatserver.helpers.JsonDateSerializer;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * Created by Victor on 06.05.2018.
 */
public class MessageDTO {



    private Long id;
    private Long from;
    private String message;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Timestamp timestamp;
    private Long contactId;
    private boolean isRead;
    private int color;

    public MessageDTO(Message message) {
        id = message.getId();
        from = message.getFrom().getId();
        this.message = message.getMessage();
        timestamp = message.getTimestamp();
        isRead = message.isRead();
        color = message.getColor();
        contactId = message.getContact().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
}