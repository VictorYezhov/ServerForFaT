package com.fatserver.dao;

import com.fatserver.entity.Skill;
import com.fatserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;


/**
 * Created by Victor-loh on 11.02.2018.
 */
public interface UserDao extends JpaRepository<User,Long>{

    User findByName(String name);
    User findByEmailAndPassword(String email, String password);

    //@Query("select j from Job j left join fetch j.userListJob u where u.id=:id")
    @Query("select s from Skill s left join fetch s.userList u where u.id=:id")
    List<Skill> findUserWithSkills(@Param("id") Long id);


}
