package com.example.projects.service;

import com.example.projects.domain.Product;
import com.example.projects.domain.User;
import com.example.projects.dto.ProductDTO;
import com.example.projects.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void delete(Integer id);
    Page<Product> getListProduct(Pageable pageable);
    ProductDTO Update(ProductDTO productDTO);
    ProductDTO Save(ProductDTO product);
    ProductDTO getProductById(Integer id);
    ProductDTO findById(Integer id);
    Page<ProductDTO> search(MultiValueMap<String, String> queryParams , Pageable pageable);
}
