package com.ozkan.minitwitter;

import com.ozkan.minitwitter.dao.PostDao;
import com.ozkan.minitwitter.dao.UserDao;
import com.ozkan.minitwitter.entity.Post;
import com.ozkan.minitwitter.entity.User;
import com.ozkan.minitwitter.utility.Util;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class MinitwitterApplication implements CommandLineRunner {

    private UserDao userDao;
    private PostDao postDao;

    public MinitwitterApplication(UserDao userDao, PostDao postDao) {
        this.userDao = userDao;
        this.postDao = postDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(MinitwitterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        List<User> users = userDao.findAll();
        List<Post> posts = postDao.findAll();
        if(users.isEmpty()){
            User user1 = User.builder().userName("Ali").userPost(posts).profilePhoto("https://pbs.twimg.com/profile_images/1638383360086011904/bs5ZdUiW_bigger.jpg").build();
            Post post1 = Post.builder().postDescription("deneme123").user(user1).build();
            userDao.save(user1);
            postDao.save(post1);
        }


    }
}