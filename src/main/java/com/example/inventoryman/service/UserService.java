package com.example.inventoryman.service;


import com.example.inventoryman.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(User user);
}
