package com.fatserver.dao;

import com.fatserver.entity.Contact;
import com.fatserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Victor on 06.05.2018.
 */
public interface ContactDao extends JpaRepository<Contact, Long> {


    @Query("select c from Contact  c where (c.side1=:userID or c.side2=:userID)")
    List<Contact> findContactsForUser(@Param("userID") User user);
}
