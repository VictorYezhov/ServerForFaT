package com.fatserver.service;

import com.fatserver.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Victor on 13.02.2018.
 */
public interface UserService {

    void save(User user);

    List<User> findAll();

    User findOne(Long id);

    void delete(Long  id);

    void update(User user);

    User findByName(String name);
    User findByEmailAndPassword(String email, String password);
    User findUserWithSkills(Long id);



}
