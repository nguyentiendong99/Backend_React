package com.example.projects.repository;

import com.example.projects.domain.Company;
import com.example.projects.repository.custom.CompanyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company , Integer> , CompanyRepositoryCustom {
    List<Company> findAll();
}
