package com.example.projects.service;

import com.example.projects.domain.Product;
import com.example.projects.domain.User;
import com.example.projects.dto.ProductDTO;
import com.example.projects.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getListProduct();
    ProductDTO Update(ProductDTO productDTO);
    ProductDTO Save(ProductDTO productDTO);
    ProductDTO getProductById(Integer id);
    ProductDTO findById(Integer id);
}
