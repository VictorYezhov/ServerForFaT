package com.fatserver.service;

import com.fatserver.dao.UserDao;
import com.fatserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 13.02.2018.
 */
@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserDao userDao;


    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userDao.findOne(id);
    }

    @Override
    public void delete(Long id) {

        userDao.delete(id);
    }

    @Override
    public void update(User user) {

        userDao.save(user);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email,password);
    }
}
