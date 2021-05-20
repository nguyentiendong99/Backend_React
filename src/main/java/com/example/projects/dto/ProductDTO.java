package com.example.projects.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private String image;
    private double price;
    private String color;
    private Date created_date;
}
