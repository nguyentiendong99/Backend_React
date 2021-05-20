package com.example.projects.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    @NotNull
    @Size(max = 200)
    private String userName;
    @NotNull
    @Size(min = 5 , max = 100)
    private String password;
    @NotBlank
    @Column(name = "email" , unique = true)
    private String email;
    @Column(name = "phone" , unique = true)
    @Size(max = 10)
    private String phoneNumber;
    private String address;
    private String image;
    private boolean activated;
    private int status;
    private Date dob;
    @Column(name = "position_id")
    private int positionID;
    @Column(name = "department_id")
    private int department_ID;
    @Column(name = "created_date")
    private Date createdDate;
    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role" ,
            joinColumns = @JoinColumn(name = "user_id") ,
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    public User(){

    }
    public User(String username, String email, String password , String phoneNumber) {
        this.userName = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
