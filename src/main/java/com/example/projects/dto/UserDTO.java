package com.example.projects.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {
    private int id;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String image;
    private boolean activated;
    private int status;
    private Date dob;
    private int position_ID;
    private int department_ID;
}
