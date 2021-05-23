package com.example.projects.dto;

import com.example.projects.domain.Agents;
import com.example.projects.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BrandDTO {
    private Integer id;
    private String name;
    private String description;
    List<Category> categories;
    Agents agents;
}
