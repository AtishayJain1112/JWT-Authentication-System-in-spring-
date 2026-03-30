package com.example.jwt.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http
                .authorizeHttpRequests(costomize ->
                        costomize
                                .requestMatchers("/api/users").hasRole("ROLE_USER")
                                .requestMatchers("/api/user/save").hasRole("ROLE_MANAGER")
                                .requestMatchers("/api/role/save").hasRole("ROLE_MANAGER")
                                .requestMatchers("/api/role/totheuser").hasRole("ROLE_ADMIN")
                                .requestMatchers("/api/*").hasRole("ROLE_SUPER_ADMIN")
                );
        return http.build();
    }
}
