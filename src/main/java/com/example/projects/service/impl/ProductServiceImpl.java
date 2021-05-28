package com.example.projects.service.impl;

import com.example.projects.domain.Product;
import com.example.projects.dto.ProductDTO;
import com.example.projects.exceptions.ResourceNotFoundException;
import com.example.projects.repository.ProductRepository;
import com.example.projects.service.ProductService;
import com.example.projects.service.mapper.ProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import javax.transaction.Transactional;
import java.util.Date;
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
    public void delete(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found product"));
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> getListProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    @Override
    public ProductDTO Update(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).get();
        product.setName(productDTO.getName());
        product.setCategoryId(productDTO.getCategoryId());
        product.setColor(productDTO.getColor());
        product.setPrice(productDTO.getPrice());
        product.setBuy_by(productDTO.getBuy_by());
        product.setModified_date(productDTO.getModified_date());
        product.setQuantity(productDTO.getQuantity());
        product.setBuy_date(productDTO.getBuy_date());
        product = productRepository.save(product);
        return productMapper.toDto(product);
    }

//    @Override
//    public Product Save(Product product) {
//        return productRepository.save(product);
//    }

    @Override
    public ProductDTO Save(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setColor(productDTO.getColor());
        product.setPrice(productDTO.getPrice());
        product.setBuy_by(productDTO.getBuy_by());
        product.setModified_date(productDTO.getModified_date());
        product.setQuantity(productDTO.getQuantity());
        product.setBuy_date(productDTO.getBuy_date());
        product.setCategoryId(productDTO.getCategoryId());
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

    @Override
    public Page<ProductDTO> search(MultiValueMap<String, String> queryParams, Pageable pageable) {
        List<ProductDTO> productDTOList = productMapper.toDto(productRepository.search(queryParams, pageable));
        return new PageImpl<>(productDTOList, pageable, productRepository.count(queryParams));
    }
}
