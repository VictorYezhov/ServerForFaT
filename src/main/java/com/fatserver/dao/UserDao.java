package com.fatserver.dao;

import com.fatserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * Created by Victor-loh on 11.02.2018.
 */
public interface UserDao extends JpaRepository<User,Long>{

    User findByName(String name);
    User findByEmailAndPassword(String email, String password);

}
