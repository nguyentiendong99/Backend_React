package com.example.projects.service.impl;

import com.example.projects.domain.Product;
import com.example.projects.dto.ProductDTO;
import com.example.projects.dto.UserDTO;
import com.example.projects.exceptions.ResourceNotFoundException;
import com.example.projects.repository.ProductRepository;
import com.example.projects.service.ProductService;
import com.example.projects.service.mapper.ProductMapper;
import javassist.tools.web.BadHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @Override
    public ProductDTO Update(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).get();
        product.setName(productDTO.getName());
        product.setColor(productDTO.getColor());
        product.setPrice(productDTO.getPrice());
        product.setBuy_by(productDTO.getBuy_by());
        product.setModified_date(productDTO.getModified_date());
        product.setCategory(productDTO.getCategory());
        product.setQuantity(productDTO.getQuantity());
        product.setBuy_date(productDTO.getBuy_date());
        product = productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    public ProductDTO Save(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setColor(productDTO.getColor());
        product.setPrice(productDTO.getPrice());
        product.setBuy_by(productDTO.getBuy_by());
        product.setModified_date(productDTO.getModified_date());
        product.setCategory(productDTO.getCategory());
        product.setQuantity(productDTO.getQuantity());
        product.setBuy_date(productDTO.getBuy_date());
        product.setCreated_date(new Date());
        product = productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        return productMapper.toDto(productRepository.findById(id).get());
    }

    @Override
    public ProductDTO findById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        return productMapper.toDto(product);
    }
}
