package com.example.projects.repository;

import com.example.projects.domain.User;
import com.example.projects.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> , UserRepositoryCustom {
    User findByEmail(String email);
}
