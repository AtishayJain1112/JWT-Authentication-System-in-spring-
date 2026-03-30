package com.example.jwt.Service;

import com.example.jwt.Entity.Role;
import com.example.jwt.Entity.UserInfo;

import java.util.List;

public interface userService {
    UserInfo saveUser (UserInfo userInfo);
    Role saveRole(Role role);
    void addRoleToUser(String userName , String roleName);
    UserInfo getUser (String userName);
    List<UserInfo> FindAllUser();
}