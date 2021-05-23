package com.example.projects.repository.custom;

import com.example.projects.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> search(MultiValueMap<String , String> queryParams , Pageable pageable);
    Long count(MultiValueMap<String, String> queryParams);
}
