package com.example.projects.repository;

import com.example.projects.domain.Agents;
import com.example.projects.repository.custom.AgentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agents , Integer> , AgentRepositoryCustom {
}
