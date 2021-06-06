package com.example.projects.service;

import com.example.projects.domain.Product;
import com.example.projects.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface ProductService {
    void delete(Integer id);
    Page<Product> getListProduct(Pageable pageable);
    List<Product> findAll();
    Page<Product> getListProductByCategoryID(Integer id , Pageable pageable);
    ProductDTO Update(ProductDTO productDTO);
    ProductDTO Save(ProductDTO product);
    ProductDTO getProductById(Integer id);
    ProductDTO findById(Integer id);
    Page<ProductDTO> search(MultiValueMap<String, String> queryParams , Pageable pageable);
}
