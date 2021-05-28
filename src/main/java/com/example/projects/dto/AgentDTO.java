package com.example.projects.dto;

import com.example.projects.domain.Brand;
import com.example.projects.domain.Stock;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AgentDTO {
    private Integer id;
    private Integer stockId;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String owner;
    private Date purchaseDate;
    private Double totalPrice;
    private Long quantity;
//    private List<Brand> brands;
//    private Stock stock;
}
