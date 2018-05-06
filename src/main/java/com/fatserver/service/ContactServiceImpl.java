package com.fatserver.service;

import com.fatserver.dao.ContactDao;
import com.fatserver.entity.Contact;
import com.fatserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 06.05.2018.
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public void save(Contact contact) {
        contactDao.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }

    @Override
    public Contact findOne(Long id) {
        return contactDao.findOne(id);
    }

    @Override
    public void delete(Long id) {

        contactDao.delete(id);
    }

    @Override
    public void update(Contact contact) {

        contactDao.save(contact);
    }

    @Override
    public List<Contact> findContactForUser(User user) {
        return contactDao.findContactsForUser(user);
    }
}
