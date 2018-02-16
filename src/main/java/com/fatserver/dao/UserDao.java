package com.fatserver.dao;

import com.fatserver.entity.Skill;
import com.fatserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.jws.soap.SOAPBinding;


/**
 * Created by Victor-loh on 11.02.2018.
 */
public interface UserDao extends JpaRepository<User,Long>{

    User findByName(String name);
    User findByEmailAndPassword(String email, String password);

    @Query("select u from User u left join fetch u.skills o where u.id=:id")
    User findUserWithSkills(@Param("id") Long id);


}
