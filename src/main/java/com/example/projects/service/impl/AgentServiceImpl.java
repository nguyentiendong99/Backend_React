package com.example.projects.service.impl;

import com.example.projects.domain.Agents;
import com.example.projects.dto.AgentDTO;
import com.example.projects.repository.AgentRepository;
import com.example.projects.service.AgentService;
import com.example.projects.service.mapper.AgentMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {
    private final AgentRepository agentRepository;
    private final AgentMapper agentMapper;

    public AgentServiceImpl(AgentRepository agentRepository, AgentMapper agentMapper) {
        this.agentRepository = agentRepository;
        this.agentMapper = agentMapper;
    }

    @Override
    public Page<Agents> getListAgent(Pageable pageable) {
        return agentRepository.findAll(pageable);
    }

    @Override
    public Page<Agents> getListAgentByStockId(Integer id , Pageable pageable) {
        return agentRepository.findByStockId(id , pageable);
    }
}
