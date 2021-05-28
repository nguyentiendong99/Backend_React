package com.example.projects.service;

import com.example.projects.domain.User;
import com.example.projects.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void delete(Integer id);
    List<User> getListUser();
    UserDTO getUserById(Integer id);
    User getUserByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByUserName(String username);
    Boolean existsByPhoneNumber(String phone);
    User save(User user);
    Page<UserDTO> search(MultiValueMap<String, String> queryParams , Pageable pageable);
    Optional<User> findOne(Integer id);
    UserDTO update(UserDTO userDTO);
}
