package com.example.projects.service.mapper;

import com.example.projects.domain.Product;
import com.example.projects.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO , Product> {
    Product toEntity(ProductDTO dto);

    ProductDTO toDto(Product entity);

    List<Product> toEntity(List<ProductDTO> dtoList);

    List<ProductDTO> toDto(List<Product> entityList);
}
