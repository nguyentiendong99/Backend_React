package com.example.projects.service.impl;

import com.example.projects.dto.AgentDTO;
import com.example.projects.repository.AgentRepository;
import com.example.projects.service.AgentService;
import com.example.projects.service.mapper.AgentMapper;
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
    public List<AgentDTO> getListAgent() {
        return agentMapper.toDto(agentRepository.findAll());
    }
}
