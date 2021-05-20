package com.example.projects.web.rest;

import com.example.projects.dto.UserDTO;
import com.example.projects.service.UserService;
import com.example.projects.service.mapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserResource {

    private final UserService userService;
   // private final UserMapper userMapper;

    public UserResource(UserService userService) {
        this.userService = userService;
        //this.userMapper = userMapper;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getListUser() {
        List<UserDTO> listUser = userService.getListUser();
        return ResponseEntity.ok().body(listUser);
    }
}
