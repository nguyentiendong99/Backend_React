package com.example.projects.web.rest;

import com.example.projects.dto.CategoryDTO;
import com.example.projects.service.CategoryService;
import com.example.projects.service.mapper.CategoryMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryResource {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryResource(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getListCategory(){
        List<CategoryDTO> list = categoryMapper.toDto(categoryService.getListCategory());
        return ResponseEntity.ok(list);
    }
}
