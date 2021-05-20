package com.example.projects.repository;

import com.example.projects.domain.User;
import com.example.projects.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> , UserRepositoryCustom {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByUserName(String username);
    Boolean existsByPhoneNumber(String phone);
    List<User> findAll();

}
