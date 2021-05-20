package com.example.projects.payload.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "user name không được để trống  ")
    @Size(min = 3 , max = 100)
    private String username;
    @NotBlank(message = "Email không được để trống  ")
    @Size(max = 100)
    @Email(message = "Email không đúng định dạng mời nhập lại")
    private String email;
    private Set<String> role;
    @NotBlank(message = "password không được để trống  ")
    @Size(message = "password tối thiểu 6 kí tự",min = 6 , max = 100)
    private String password;
    @NotBlank(message = "số điện thoại không được để trống  ")
    private String phone;
    private String address;
    private String image;
}
