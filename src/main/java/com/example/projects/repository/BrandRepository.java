package com.example.projects.repository;

import com.example.projects.domain.Brand;
import com.example.projects.dto.BrandDTO;
import com.example.projects.repository.custom.BrandRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand , Integer> , BrandRepositoryCustom {
}
