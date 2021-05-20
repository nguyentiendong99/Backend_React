package com.example.projects.service;

import com.example.projects.domain.User;
import com.example.projects.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getListUser();
    User getUserByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByUserName(String username);
    Boolean existsByPhoneNumber(String phone);
    User save(User user);
}
