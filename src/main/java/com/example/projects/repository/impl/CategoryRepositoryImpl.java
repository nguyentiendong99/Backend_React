package com.example.projects.repository.impl;

import com.example.projects.domain.Category;
import com.example.projects.repository.custom.CategoryRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> getListCategory() {
        String sql = "select c from Category c";
        Query query = entityManager.createQuery(sql , Category.class);
        return query.getResultList();
    }
}
