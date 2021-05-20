package com.example.projects.service.impl;

import com.example.projects.dto.ProductDTO;
import com.example.projects.repository.ProductRepository;
import com.example.projects.service.ProductService;
import com.example.projects.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> getListProduct() {
        return productMapper.toDto(productRepository.findAll());
    }
}
