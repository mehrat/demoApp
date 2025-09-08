package com.example.demomusic.services.impl;

import com.example.demomusic.repository.UserDao;
import com.example.demomusic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean validateUserRegistered(String userEmail) {
        return userDao.validateUserInDataBase(userEmail);
    }
}
