package com.example.projects.service.mapper;


import com.example.projects.domain.User;
import com.example.projects.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
