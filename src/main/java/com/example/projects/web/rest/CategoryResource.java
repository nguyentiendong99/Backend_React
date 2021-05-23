package com.example.projects.web.rest;

import com.example.projects.dto.CategoryDTO;
import com.example.projects.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryResource {
    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getListCategory(){
        List<CategoryDTO> list = categoryService.getListCategory();
        return ResponseEntity.ok().body(list);
    }
}
