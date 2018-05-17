package com.fatserver.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fatserver.entity.Contact;
import com.fatserver.entity.User;
import com.fatserver.helpers.JsonDateSerializer;

import java.sql.Timestamp;

/**
 * Created by Victor on 06.05.2018.
 */
public class ContactDTO {

    private Long  id;
    private String from;
    private Long idFrom;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Timestamp timestamp;
    private String lastMessageText;

    public ContactDTO() {
    }

    public ContactDTO(Contact contact, User userfrom) {
        id =  contact.getId();
        from = userfrom.getName()+" "+userfrom.getFamilyName();
        idFrom = userfrom.getId();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(Long idFrom) {
        this.idFrom = idFrom;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getLastMessageText() {
        return lastMessageText;
    }

    public void setLastMessageText(String lastMessageText) {
        this.lastMessageText = lastMessageText;
    }
}
