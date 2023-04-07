package com.ozkan.minitwitter.dao;

import com.ozkan.minitwitter.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post, Long> {

}