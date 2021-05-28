package com.example.projects.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private Integer id;
    private Integer brandId;
    private String name;
    private Long quantity;
    private String description;
}
