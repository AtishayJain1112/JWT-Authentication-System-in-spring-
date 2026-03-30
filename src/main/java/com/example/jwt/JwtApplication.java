package com.example.jwt;

import com.example.jwt.Entity.Role;
import com.example.jwt.Entity.UserInfo;
import com.example.jwt.Service.userService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(userService user){
		return args -> {

			// adding role
			user.saveRole(new Role(null,"ROLE_USER"));
			user.saveRole(new Role(null,"ROLE_MANAGER"));
			user.saveRole(new Role(null,"ROLE_ADMIN"));
			user.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			//adding users
			user.saveUser(new UserInfo(null,"Atishay jain","atishay","qwert",new ArrayList<>()));
			user.saveUser(new UserInfo(null,"Amit jain","amit","qwert",new ArrayList<>()));
			user.saveUser(new UserInfo(null,"Aadi jain","aadi","qwert",new ArrayList<>()));
			user.saveUser(new UserInfo(null,"Mukesh jain","mukesh","qwert",new ArrayList<>()));

			// adding roles to the users
			user.addRoleToUser("atishay", "ROLE_USER");
			user.addRoleToUser("atishay", "ROLE_MANAGER");
			user.addRoleToUser("amit", "ROLE_MANAGER");
			user.addRoleToUser("aadi", "ROLE_USER");
			user.addRoleToUser("aadi", "ROLE_ADMIN");
			user.addRoleToUser("mukesh", "ROLE_SUPER_ADMIN");
			user.addRoleToUser("mukesh", "ROLE_USER");
			user.addRoleToUser("mukesh", "ROLE_ADMIN");

		};

	}

}
