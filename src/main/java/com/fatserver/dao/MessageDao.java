package com.fatserver.dao;

import com.fatserver.entity.Contact;
import com.fatserver.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * Created by Victor on 06.05.2018.
 */
public interface MessageDao extends JpaRepository<Message, Long> {

    @Query(value = "SELECT * from message WHERE message.contact_id=:contactId and is_read =:_False ",nativeQuery = true)
    List<Message> findAllByContactNotReaded(@Param("contactId") Long contactId, @Param("_False") boolean _False);

    List<Message> findAllByContact(@Param("contact") Contact contact);



    @Query(value = "select DISTINCT * from message where message.timestamp =" +
            "(select max(res.timestamp) as maximum from (select  * from findatutor.message where message.contact_id =:contactID)as res) and contact_id =:contactID LIMIT 1",
            nativeQuery = true)
    Message findDistinctByContactOrderByTimestamp(@Param("contactID") Long contactID);


}
