package com.example.projects.service.mapper;

import com.example.projects.domain.Category;
import com.example.projects.dto.CategoryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO , Category> {
    @Override
    Category toEntity(CategoryDTO dto);

    @Override
    CategoryDTO toDto(Category entity);

    @Override
    List<Category> toEntity(List<CategoryDTO> dtoList);

    @Override
    List<CategoryDTO> toDto(List<Category> entityList);
}
