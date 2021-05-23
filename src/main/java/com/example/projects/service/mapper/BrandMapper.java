package com.example.projects.service.mapper;

import com.example.projects.domain.Brand;
import com.example.projects.dto.BrandDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper extends EntityMapper<BrandDTO , Brand> {
    Brand toEntity(BrandDTO dto);

    BrandDTO toDto(Brand entity);

    List<Brand> toEntity(List<BrandDTO> dtoList);

    List<BrandDTO> toDto(List<Brand> entityList);
}
