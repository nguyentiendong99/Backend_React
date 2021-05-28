package com.example.projects.repository.impl;

import com.example.projects.domain.Company;
import com.example.projects.repository.custom.CompanyRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CompanyRepositoryImpl implements CompanyRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getListCompany() {
        String sql = "select c from Company c";
        Query query = entityManager.createQuery(sql , Company.class);
        return query.getResultList();
    }
}
