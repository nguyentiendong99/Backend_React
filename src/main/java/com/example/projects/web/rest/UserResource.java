package com.example.projects.web.rest;

import com.example.projects.domain.User;
import com.example.projects.dto.ProductDTO;
import com.example.projects.dto.UserDTO;
import com.example.projects.service.UserService;
import com.example.projects.service.mapper.UserMapper;
import com.example.projects.web.rest.util.PaginationUtil;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/users/search")
    public ResponseEntity<List<UserDTO>> search(@RequestParam MultiValueMap<String, String> queryParams,
                                                Pageable pageable) {
        Page<UserDTO> page = userService.search(queryParams, pageable);
        HttpHeaders headers = PaginationUtil    
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequestUri(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable("id") Integer id){
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok().body(userDTO);
    }
    @PutMapping("/users")
    public ResponseEntity<UserDTO> update(@RequestBody @Valid UserDTO userDTO) {
        UserDTO result = userService.update(userDTO);
        return ResponseEntity.ok().body(result);
    }
}
