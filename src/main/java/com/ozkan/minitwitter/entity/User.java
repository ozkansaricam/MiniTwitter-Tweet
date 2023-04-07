package com.ozkan.minitwitter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Basic
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Basic
    @Column(name = "profile_photo", nullable = false)
    private String profilePhoto;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> userPost = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!userId.equals(user.userId)) return false;
        if (!Objects.equals(userName, user.userName)) return false;
        return Objects.equals(profilePhoto, user.profilePhoto);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (profilePhoto != null ? profilePhoto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", userName='" + userName + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                '}';
    }
}