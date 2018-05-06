package com.fatserver.service;

import com.fatserver.entity.Contact;
import com.fatserver.entity.Job;
import com.fatserver.entity.Message;

import java.util.List;

/**
 * Created by Victor on 06.05.2018.
 */
public interface MessageService {

    void save(Message message);

    List<Message> findAll();

    Message findOne(Long id);

    void delete(Long  id);

    void update(Message message);

    List<Message> findAllByContact(Contact contact);





}
