package com.example.projects.repository;

import com.example.projects.domain.Agents;
import com.example.projects.repository.custom.AgentRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agents , Integer> , AgentRepositoryCustom {
    Page<Agents> findAll(Pageable pageable);
    Page<Agents> findByStockId(Integer id , Pageable pageable);
}
