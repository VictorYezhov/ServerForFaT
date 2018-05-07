package com.fatserver.service;

import com.fatserver.entity.Contact;
import com.fatserver.entity.Country;
import com.fatserver.entity.User;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Victor on 06.05.2018.
 */
public interface ContactService {

    void save(Contact contact);

    List<Contact> findAll();

    Contact findOne(Long id);

    void delete(Long  id);

    void update(Contact contact);

    List<Contact> findContactForUser(User user);

    BigInteger checkIfContactExists(Long side1, Long side2);






}
