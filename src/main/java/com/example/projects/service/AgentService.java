package com.example.projects.service;

import com.example.projects.domain.Agents;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AgentService {
    Page<Agents> getListAgent(Pageable pageable);
    Page<Agents> getListAgentByStockId(Integer id , Pageable pageable);
}
