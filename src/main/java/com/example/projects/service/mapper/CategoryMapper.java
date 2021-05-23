package com.example.projects.service.mapper;

import com.example.projects.domain.Category;
import com.example.projects.dto.CategoryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO , Category >{
    Category toEntity(CategoryDTO dto);

    CategoryDTO toDto(Category entity);

    List<Category> toEntity(List<CategoryDTO> dtoList);

    List<CategoryDTO> toDto(List<Category> entityList);
}
