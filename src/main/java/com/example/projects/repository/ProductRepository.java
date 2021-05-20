package com.example.projects.repository;

import com.example.projects.domain.Product;
import com.example.projects.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> , ProductRepositoryCustom {
}
