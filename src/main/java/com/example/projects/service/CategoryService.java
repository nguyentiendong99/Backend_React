package com.example.projects.service;

import com.example.projects.domain.Category;
import com.example.projects.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    Page<Category> getListCategory(Pageable pageable);
    Page<Category> getListCategoryByBrandId(Integer id , Pageable pageable);
}
