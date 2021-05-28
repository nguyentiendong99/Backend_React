package com.example.projects.repository.impl;

import com.example.projects.domain.Agents;
import com.example.projects.repository.custom.AgentRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class AgentRepositoryImpl implements AgentRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Agents> getListAgents() {
        String sql = "select a from Agents a";
        Query query = entityManager.createQuery(sql , Agents.class);
        return query.getResultList();
    }
}
