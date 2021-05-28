package com.example.projects.service.mapper;

import com.example.projects.domain.Product;
import com.example.projects.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO , Product> {
    Product toEntity(ProductDTO dto);

    ProductDTO toDto(Product entity);

}
