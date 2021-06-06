package com.example.projects.repository;

import com.example.projects.domain.Product;
import com.example.projects.repository.custom.ProductRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>, ProductRepositoryCustom {
    Page<Product> findByCategoryId(Integer id , Pageable pageable);
}
