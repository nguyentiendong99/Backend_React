package com.example.projects.repository;

import com.example.projects.domain.Company;
import com.example.projects.repository.custom.CompanyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company , Integer> , CompanyRepositoryCustom {
}
