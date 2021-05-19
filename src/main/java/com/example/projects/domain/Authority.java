package com.example.projects.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * An authority (a security role) used by Spring Security.
 */
@Data
@Entity
@Table(name = "authority")
public class Authority{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "code")
    private String code;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "menu_url")
    private String menuUrl;

    @Column(name = "method")
    private String method;

    @Column(name = "status", columnDefinition="default 1")
    private Integer status;
}

