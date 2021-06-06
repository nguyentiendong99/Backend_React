package com.example.projects.repository.impl;

import com.example.projects.domain.StockPlace;
import com.example.projects.repository.custom.StockPlaceRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class StockPlaceRepositoryImpl implements StockPlaceRepositoryCustom {
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Override
//    public List<StockPlace> getListStockPlace() {
//        String sql = "select s from StockPlace s";
//        Query query = entityManager.createQuery(sql ,StockPlace.class);
//        return query.getResultList();
//    }

//    @Override
//    public List<StockPlace> getListStockPlaceByCompanyID(Integer id) {
//        String sql = "select s from StockPlace s where s.companyId = :id";
//        Query query = entityManager.createQuery(sql , StockPlace.class);
//        return query.getResultList();
//    }
}
