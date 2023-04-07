package com.ozkan.minitwitter.dao;

import com.ozkan.minitwitter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long> {

    @Query("select u from User as u where u.userName=:name")
    User findByUserName(@Param("name") String name);
}