package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Login")
public class User {

    @Column
    private String Name;
    @Id
    @Column
    private String Email;

    @Column
    private String Password;
    public User(String Name,String Email,String Password){
        this.Name=Name;
        this.Email=Email;
        this.Password=Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Password=" + Password +
                '}';
    }
}
