package com.example.projects.service.impl;

import com.example.projects.domain.User;
import com.example.projects.dto.UserDTO;
import com.example.projects.exceptions.ResourceNotFoundException;
import com.example.projects.repository.UserRepository;
import com.example.projects.service.UserService;
import com.example.projects.service.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void delete(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getListUser() {
        return userRepository.getListUser();
    }

    @Override
    public UserDTO getUserById(Integer id) {
        return userMapper.toDto(userRepository.findById(id).get());
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByUserName(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public Boolean existsByPhoneNumber(String phone) {
        return userRepository.existsByPhoneNumber(phone);
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public Page<UserDTO> search(MultiValueMap<String, String> queryParams, Pageable pageable) {
        List<UserDTO> userDTOList = userMapper.toDto(userRepository.search(queryParams, pageable));
        return new PageImpl<>(userDTOList, pageable, userRepository.count(queryParams));
    }

    @Override
    public Optional<User> findOne(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId()).get();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setImage(userDTO.getImage());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }
}
