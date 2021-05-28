package com.example.projects.service;

import com.example.projects.domain.Category;
import com.example.projects.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<Category> getListCategory();
}
