package com.ozkan.minitwitter.service;

import com.ozkan.minitwitter.entity.User;

import java.util.List;

public interface UserService {

    List<User> listAllUsers();
    User findUserByName(String name);
}