package com.example.jwt.repo;

import com.example.jwt.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserInfo,Long> {
    public UserInfo findByUsername(String userName);
}
