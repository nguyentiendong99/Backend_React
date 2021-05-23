package com.example.projects.repository.impl;

import com.example.projects.domain.User;
import com.example.projects.repository.custom.UserRepositoryCustom;
import com.example.projects.utils.StrUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> search(MultiValueMap<String, String> queryParams, Pageable pageable) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT U FROM User U ");

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
        sql.append("SELECT COUNT(U) FROM User U ");
        Map<String, Object> values = new HashMap<>();
        sql.append(createWhereQuery(queryParams, values));
        Query query = entityManager.createQuery(sql.toString());
        values.forEach(query::setParameter);
        return (Long) query.getSingleResult();

    }

    private String createWhereQuery(MultiValueMap<String, String> queryParams, Map<String, Object> values) {
        StringBuilder sql = new StringBuilder();
        sql.append(" WHERE 1 = 1 ");
        if (queryParams.containsKey("keyword")) {
            sql.append(" and (LOWER(U.phoneNumber) like LOWER(:keyword) or LOWER(U.userName) like LOWER(:keyword) OR ")
                    .append("LOWER(U.email) LIKE LOWER(:keyword) or LOWER(U.address) LIKE LOWER(:keyword)) ");
            values.put("keyword", "%" + queryParams.get("keyword").get(0) + "%");
        }
        if (queryParams.containsKey("keywordExactly") && !StrUtil.isBlank(queryParams.get("keywordExactly").get(0))) {
            sql.append(" and (lower(U.phoneNumber) = lower(:keywordExactly) or lower(U.userName) = lower(:keywordExactly) or lower(U" +
                    ".email) = lower(:keywordExactly) or lower(U.address) = lower(:keywordExactly) )");
            values.put("keywordExactly", queryParams.get("keywordExactly").get(0));
        }
        if (queryParams.containsKey("status") && !StrUtil.isBlank(queryParams.get("status").get(0))) {
            sql.append(" AND U.status = :status ");
            values.put("status", Integer.parseInt(queryParams.get("status").get(0)));
        }

        if (queryParams.containsKey("activated")) {
            sql.append(" AND U.activated = :activated ");
            values.put("activated", Boolean.parseBoolean(queryParams.get("activated").get(0)));
        }
        if (queryParams.containsKey("email")) {
            sql.append(" AND LOWER(U.email) LIKE LOWER(:email)");
            values.put("email", "%" + queryParams.get("email").get(0) + "%");
        }
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
        sql.append(" order by U.userName desc ");
        return sql;

    }
}
