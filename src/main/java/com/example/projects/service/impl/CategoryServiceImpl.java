package com.example.projects.service.impl;

import com.example.projects.domain.Category;
import com.example.projects.dto.CategoryDTO;
import com.example.projects.repository.CategoryRepository;
import com.example.projects.service.CategoryService;
import com.example.projects.service.mapper.CategoryMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Page<Category> getListCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Page<Category> getListCategoryByBrandId(Integer id , Pageable pageable) {
        return categoryRepository.findByBrandId(id , pageable);
    }
}
