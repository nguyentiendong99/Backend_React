package com.example.projects.repository.impl;

import com.example.projects.domain.Stock;
import com.example.projects.repository.custom.StockRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class StockRepositoryImpl implements StockRepositoryCustom {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Stock> getListStock() {
//        String sql = "select s from Stock s";
//        Query query = entityManager.createQuery(sql , Stock.class);
//        return query.getResultList();
//    }
}
