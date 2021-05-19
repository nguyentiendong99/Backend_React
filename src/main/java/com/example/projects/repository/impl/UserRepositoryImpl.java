package com.example.projects.repository.impl;

import com.example.projects.domain.User;
import com.example.projects.repository.custom.UserRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getListUser() {
        String sql = "SELECT u FROM User u";
        Query query = entityManager.createQuery(sql , User.class);
        return query.getResultList();
    }
}
