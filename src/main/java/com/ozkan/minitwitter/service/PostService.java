package com.ozkan.minitwitter.service;

import com.ozkan.minitwitter.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> listAllPosts();
    Post createPost(Post post);
}