package com.example.projects.payload.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "user name khong duoc de trong")
    private String username;
    @NotBlank(message = "password khong duoc de trong")
    private String password;

}
