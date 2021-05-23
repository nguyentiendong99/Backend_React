package com.example.projects.service.mapper;

import com.example.projects.domain.Brand;
import com.example.projects.dto.BrandDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper extends EntityMapper<BrandDTO , Brand> {
    @Override
    Brand toEntity(BrandDTO dto);

    @Override
    BrandDTO toDto(Brand entity);

    @Override
    List<Brand> toEntity(List<BrandDTO> dtoList);

    @Override
    List<BrandDTO> toDto(List<Brand> entityList);
}
