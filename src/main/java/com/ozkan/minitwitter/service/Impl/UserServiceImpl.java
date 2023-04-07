package com.ozkan.minitwitter.service.Impl;

import com.ozkan.minitwitter.dao.UserDao;
import com.ozkan.minitwitter.entity.User;
import com.ozkan.minitwitter.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> listAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User findUserByName(String name) {
        return userDao.findByUserName(name);
    }
}