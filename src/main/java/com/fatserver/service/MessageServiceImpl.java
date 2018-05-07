package com.fatserver.service;

import com.fatserver.dao.MessageDao;
import com.fatserver.entity.Contact;
import com.fatserver.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 06.05.2018.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public void save(Message message) {
        messageDao.save(message);
    }

    @Override
    public List<Message> findAll() {
        return messageDao.findAll();
    }

    @Override
    public Message findOne(Long id) {
        return messageDao.findOne(id);
    }

    @Override
    public void delete(Long id) {

        messageDao.delete(id);
    }

    @Override
    public void update(Message message) {

        messageDao.save(message);
    }

    @Override
    public List<Message> findAllByContact(Contact contact) {
        return messageDao.findAllByContactNotReaded(contact.getId(), false);
    }

    @Override
    public Message findLastMessageForContact(Contact contact) {
        return messageDao.findDistinctByContactOrderByTimestamp(contact.getId());
    }

    @Override
    public List<Message> findAllForContact(Contact contact) {
        return messageDao.findAllByContact(contact);
    }
}
