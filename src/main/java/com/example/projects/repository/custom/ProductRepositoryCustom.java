package com.example.projects.repository.custom;

import com.example.projects.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> search(MultiValueMap<String, String> queryParams , Pageable pageable);
    Long count(MultiValueMap<String, String> queryParams);
    List<Product> getListProduct();
}
