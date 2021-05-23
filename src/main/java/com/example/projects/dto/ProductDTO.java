package com.example.projects.dto;

import com.example.projects.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDTO {
    private Integer id;
    private String name;
    private Double price;
    private String color;
    private Integer quantity;
    private Date created_date;
    private Date modified_date;
    private String buy_by;
    private Date buy_date;
    Category category;
}
