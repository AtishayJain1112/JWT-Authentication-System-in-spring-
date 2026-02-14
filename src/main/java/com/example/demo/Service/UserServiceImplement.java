package com.example.demo.Service;

import com.example.demo.Dao.UserRepo;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImplement implements UserService{

    UserRepo userRepo;
    @Autowired
    public UserServiceImplement(UserRepo theUserRepo){
        userRepo =theUserRepo;
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> result = userRepo.findById(email);
        User user= null;
        if(result.isPresent()){
            user =result.get();
        }else{
            throw new RuntimeException("User not present");
        }

        return null;
    }

    @Override
    public User save(User theUser) {
        return userRepo.save(theUser);
    }

    @Override
    public void Delete(String email) {
         userRepo.deleteById(email);
    }
}
