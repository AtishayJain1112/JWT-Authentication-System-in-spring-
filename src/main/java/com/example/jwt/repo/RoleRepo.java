package com.example.jwt.repo;



import com.example.jwt.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    public Role findByName(String Name);
}
