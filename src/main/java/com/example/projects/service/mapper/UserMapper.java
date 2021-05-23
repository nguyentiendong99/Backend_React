package com.example.projects.service.mapper;


import com.example.projects.domain.User;
import com.example.projects.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
    User toEntity(UserDTO dto);

    UserDTO toDto(User entity);

    List<User> toEntity(List<UserDTO> dtoList);

    List<UserDTO> toDto(List<User> entityList);
}
