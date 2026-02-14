package com.example.demo.Service;

import com.example.demo.Entity.User;

public interface UserService {
    User findByEmail(String email);
    User save(User theUser);
    void Delete(String email);
}
