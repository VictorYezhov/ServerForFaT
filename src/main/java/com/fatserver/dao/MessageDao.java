package com.fatserver.dao;

import com.fatserver.entity.Contact;
import com.fatserver.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Victor on 06.05.2018.
 */
public interface MessageDao extends JpaRepository<Message, Long> {

    List<Message> findAllByContact(Contact contact);


}
