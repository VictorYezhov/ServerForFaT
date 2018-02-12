package com.fatserver.dao;

import com.fatserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Victor on 11.02.2018.
 */
public interface UserDao extends JpaRepository<User,Long>{

    User findByName(String name);

}
