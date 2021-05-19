package com.example.projects.service.impl;

import com.example.projects.domain.User;
import com.example.projects.repository.UserRepository;
import com.example.projects.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getListUser() {
        return userRepository.getListUser();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }
}
