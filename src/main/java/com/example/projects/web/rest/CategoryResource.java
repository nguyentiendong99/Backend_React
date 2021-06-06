package com.example.projects.web.rest;

import com.example.projects.domain.Category;
import com.example.projects.dto.CategoryDTO;
import com.example.projects.service.CategoryService;
import com.example.projects.service.mapper.CategoryMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryResource {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryResource(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/categories")
    public ResponseEntity<Page<Category>> getListCategory(int pageNumber , int pageSize){
        Page<Category> page = categoryService.getListCategory(
                PageRequest.of(
                        pageNumber , pageSize
                )
        );
        return ResponseEntity.ok(page);
    }
    @GetMapping("categories/brand/{id}")
    public ResponseEntity<Page<Category>> getListCategoryByBrandId(
            @PathVariable("id") Integer id , int pageNumber , int pageSize){
        Page<Category> page = categoryService.getListCategoryByBrandId(id ,
                PageRequest.of(
                        pageNumber , pageSize
                ));
        return ResponseEntity.ok().body(page);
    }
}
