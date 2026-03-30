package com.example.jwt.Service;

import com.example.jwt.Entity.Role;
import com.example.jwt.Entity.UserInfo;
import com.example.jwt.repo.RoleRepo;
import com.example.jwt.repo.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class userServiceImpl implements userService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public UserInfo saveUser(UserInfo userInfo) {
        log.info("Saving the user {} to the database", userInfo.getName());
        return userRepo.save(userInfo);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving the Role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("adding the Role {} of the user {} to the database", roleName,userName);
        UserInfo user = userRepo.findByUsername(userName);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public UserInfo getUser(String userName) {
        log.info("fetching {} from the database", userName);
        return userRepo.findByUsername(userName);
    }

    @Override
    public List<UserInfo> FindAllUser() {
        log.info("fetching all the users");
        return userRepo.findAll();
    }
}
