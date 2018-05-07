package com.fatserver.dao;

import com.fatserver.entity.Contact;
import com.fatserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Victor on 06.05.2018.
 */
public interface ContactDao extends JpaRepository<Contact, Long> {


    @Query("select c from Contact  c where (c.side1=:userID or c.side2=:userID)")
    List<Contact> findContactsForUser(@Param("userID") User user);


    @Query(value = "SELECT EXISTS(SELECT * FROM contact WHERE side1_id=:side1 and side2_id =:side2)", nativeQuery = true)
    BigInteger checkIfContactExists(@Param("side1") Long side1, @Param("side2") Long side2);


    @Query(value = "SELECT * FROM contact WHERE (side1_id=:side1 and side2_id =:side2) or (side1_id=:side2 and side2_id =:side1)", nativeQuery = true)
    Contact findContactBySides(@Param("side1") Long side1, @Param("side2") Long side2);
}
