package com.ozkan.minitwitter.controller;

import com.ozkan.minitwitter.entity.Post;
import com.ozkan.minitwitter.entity.User;
import com.ozkan.minitwitter.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



}