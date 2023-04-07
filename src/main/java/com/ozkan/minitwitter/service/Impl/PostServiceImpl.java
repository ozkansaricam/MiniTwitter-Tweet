package com.ozkan.minitwitter.service.Impl;

import com.ozkan.minitwitter.dao.PostDao;
import com.ozkan.minitwitter.entity.Post;
import com.ozkan.minitwitter.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostDao postDao;

    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Post> listAllPosts() {
        return postDao.findAll();
    }

    @Override
    public Post createPost(Post post) {
        return postDao.save(post);
    }
}