package com.example.projects.repository.impl;

import com.example.projects.domain.Brand;
import com.example.projects.repository.custom.BrandRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BrandRepositoryImpl implements BrandRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Brand> getListBrand() {
        String sql = "select b from Brand b";
        Query query = entityManager.createQuery(sql , Brand.class);
        return query.getResultList();
    }
}
