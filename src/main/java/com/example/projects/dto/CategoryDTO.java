package com.example.projects.dto;

import com.example.projects.domain.Brand;
import com.example.projects.domain.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDTO {
    private Integer id;
    private String name;
    private Long quantity;
    private String description;
    List<Product> products;
    Brand brand;
}
