package com.example.projects.repository.impl;

import com.example.projects.domain.Product;
import com.example.projects.repository.custom.ProductRepositoryCustom;
import com.example.projects.utils.StrUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> search(MultiValueMap<String, String> queryParams, Pageable pageable) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT P FROM Product P ");

        Map<String, Object> values = new HashMap<>();
        sql.append(createWhereQuery(queryParams, values));
        sql.append(createOrderQuery());
        Query query = entityManager.createQuery(sql.toString());
        values.forEach(query::setParameter);
        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
            query.setMaxResults(pageable.getPageSize());
        }
        return query.getResultList();
    }

    @Override
    public Long count(MultiValueMap<String, String> queryParams) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(P) FROM Product P ");
        Map<String, Object> values = new HashMap<>();
        sql.append(createWhereQuery(queryParams, values));
        Query query = entityManager.createQuery(sql.toString());
        values.forEach(query::setParameter);
        return (Long) query.getSingleResult();

    }

    @Override
    public List<Product> getListProduct() {
        String sql = "select p from Product p";
        Query query = entityManager.createQuery(sql , Product.class);
        return query.getResultList();
    }

    private String createWhereQuery(MultiValueMap<String, String> queryParams, Map<String, Object> values) {
        StringBuilder sql = new StringBuilder();
        sql.append(" WHERE 1 = 1 ");
        if (queryParams.containsKey("keyword")) {
            sql.append(" and (LOWER(P.name) like LOWER(:keyword) or LOWER(P.price) like LOWER(:keyword) OR ")
                    .append("LOWER(P.color) LIKE LOWER(:keyword) )");
            values.put("keyword", "%" + queryParams.get("keyword").get(0) + "%");
        }
        if (queryParams.containsKey("keywordExactly") && !StrUtil.isBlank(queryParams.get("keywordExactly").get(0))) {
            sql.append(" and (lower(P.name) = lower(:keywordExactly) or lower(P.price) = lower(:keywordExactly) or lower(P" +
                    ".color) = lower(:keywordExactly) )");
            values.put("keywordExactly", queryParams.get("keywordExactly").get(0));
        }
        if (queryParams.containsKey("name") && !StrUtil.isBlank(queryParams.get("name").get(0))) {
            sql.append(" AND P.name = :name ");
            values.put("name", queryParams.get("name").get(0));
        }

        if (queryParams.containsKey("color")) {
            sql.append(" AND P.color = :color ");
            values.put("color", queryParams.get("color").get(0));
        }
//        if (queryParams.containsKey("created_date")) {
//            sql.append(" AND LOWER(P.created_date) LIKE LOWER(:created_date)");
//            values.put("created_date", "%" + queryParams.get("email").get(0) + "%");
//        }
//        if (queryParams.containsKey("startDate") && !StrUtil.isBlank(queryParams.get("startDate").get(0))) {
//            Instant instantFrom = DateUtils.parseStartOfDay(queryParams.get("startDate").get(0));
//            if (instantFrom != null) {
//                sql.append(" AND U.createdDate >= :startDate ");
//                values.put("startDate", instantFrom);
//            }
//        }
//
//        if (queryParams.containsKey("endDate") && !StrUtil.isBlank(queryParams.get("endDate").get(0))) {
//            Instant instantTo = DateUtils.parseStartOfDay(queryParams.get("endDate").get(0));
//            if (instantTo != null) {
//                sql.append(" AND U.createdDate <= :endDate ");
//                values.put("endDate", instantTo);
//            }
//        }
        return sql.toString();
    }
    private StringBuilder createOrderQuery() {
        StringBuilder sql = new StringBuilder();
        sql.append(" order by P.price desc ");
        return sql;

    }
}
