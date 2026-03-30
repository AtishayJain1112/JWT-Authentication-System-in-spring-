package com.example.jwt.api;

import com.example.jwt.Entity.Role;
import com.example.jwt.Entity.UserInfo;
import com.example.jwt.Service.userService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
    @Autowired
    private userService user;
    @GetMapping("/users")
    public ResponseEntity<List<UserInfo>> getUser(){
        return  ResponseEntity.ok().body(user.FindAllUser());
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserInfo> saveUser(@RequestBody UserInfo userInfo){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return  ResponseEntity.created(uri).body(user.saveUser(userInfo));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return  ResponseEntity.created(uri).body(user.saveRole(role));
    }

    @PostMapping("/role/totheuser")
    public ResponseEntity<?> addroletotheuser(@RequestBody RoleToUserForm form){
        user.addRoleToUser(form.getUserName(),form.getRoleName());
        return  ResponseEntity.ok().build();
    }
}
@Data
class RoleToUserForm{
    private String UserName;
    private String RoleName;
}
