package com.example.projects.dto;

import com.example.projects.domain.Brand;
import com.example.projects.domain.Stock;

import java.util.Date;
import java.util.List;

public class AgentDTO {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String owner;
    private Date purchaseDate;
    private Double totalPrice;
    private Long quantity;
    List<Brand> brands;
    Stock stock;
}
