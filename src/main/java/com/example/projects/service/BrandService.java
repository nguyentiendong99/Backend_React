package com.example.projects.service;

import com.example.projects.domain.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {
    Page<Brand> getListBrand(Pageable pageable);
    Page<Brand> getListBrandByAgentId(Integer id , Pageable pageable);
}
