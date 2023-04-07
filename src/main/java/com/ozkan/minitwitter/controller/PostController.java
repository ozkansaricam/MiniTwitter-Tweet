package com.ozkan.minitwitter.controller;

import com.ozkan.minitwitter.dao.PostDao;
import com.ozkan.minitwitter.dao.UserDao;
import com.ozkan.minitwitter.entity.Post;
import com.ozkan.minitwitter.entity.User;
import com.ozkan.minitwitter.service.PostService;
import com.ozkan.minitwitter.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class PostController {

    private PostService postService;
    private UserService userService;

    private PostDao postDao;
    private UserDao userDao;
    public PostController(PostService postService, UserService userService, PostDao postDao, UserDao userDao) {
        this.postService = postService;
        this.userService = userService;
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping
    public String myPosts(Model model){
        List<Post> posts = postService.listAllPosts();
        List<User> users = userService.listAllUsers();
        model.addAttribute("posts", posts);
        model.addAttribute("users",users);
        return "index";
    }



    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public String createPost(@RequestParam("posttext") String posttext){
        Post savedPost = new Post();
        savedPost.setPostDescription(posttext);
        savedPost.setUser(userDao.findByUserName("Özkan"));
        postDao.save(savedPost);

        return "redirect:/";
    }



}