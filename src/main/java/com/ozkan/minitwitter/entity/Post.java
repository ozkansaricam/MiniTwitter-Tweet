package com.ozkan.minitwitter.entity;

import com.ozkan.minitwitter.dao.UserDao;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
@Builder
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Basic
    @Column(name = "description")
    private String postDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private User user;



    public static List<User> assignPostToUser(UserDao userDao, List<Post> posts){
        List<User> allUsers = userDao.findAll();
        allUsers.stream().forEach(user -> user.setUserPost(posts));
        return allUsers;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;

        if (!postId.equals(post.postId)) return false;
        return Objects.equals(postDescription, post.postDescription);
    }

    @Override
    public int hashCode() {
        int result = postId.hashCode();
        result = 31 * result + (postDescription != null ? postDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postDescription='" + postDescription + '\'' +
                '}';
    }
}