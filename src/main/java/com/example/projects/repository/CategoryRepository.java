package com.example.projects.repository;

import com.example.projects.domain.Category;
import com.example.projects.repository.custom.CategoryRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category , Integer>, CategoryRepositoryCustom {
    Page<Category> findAll(Pageable pageable);
    Page<Category> findByBrandId(Integer id , Pageable pageable);
}
