package com.example.projects.service;

import com.example.projects.domain.Authority;
import com.example.projects.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> getListUser();
    User getUserByEmail(String email);
    User getUserById(Long id);
}
