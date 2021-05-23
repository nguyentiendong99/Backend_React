package com.example.projects.repository;

import com.example.projects.domain.Category;
import com.example.projects.repository.custom.CategoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Integer> , CategoryRepositoryCustom {
    List<Category> findAll();
}
