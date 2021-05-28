package com.example.projects.service.mapper;

import com.example.projects.domain.Category;
import com.example.projects.dto.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO , Category>{
    Category toEntity(CategoryDTO dto);

    CategoryDTO toDto(Category entity);
}
