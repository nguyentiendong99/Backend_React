package com.example.projects.service.mapper;

import com.example.projects.domain.Product;
import com.example.projects.dto.ProductDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
    @Override
    Product toEntity(ProductDTO dto);

    @Override
    ProductDTO toDto(Product entity);

    @Override
    List<Product> toEntity(List<ProductDTO> dtoList);

    @Override
    List<ProductDTO> toDto(List<Product> entityList);
}