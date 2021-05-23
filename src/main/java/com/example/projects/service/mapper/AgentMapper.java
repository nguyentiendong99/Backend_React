package com.example.projects.service.mapper;

import com.example.projects.domain.Agents;
import com.example.projects.dto.AgentDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgentMapper extends EntityMapper<AgentDTO , Agents> {
    @Override
    Agents toEntity(AgentDTO dto);

    @Override
    AgentDTO toDto(Agents entity);

    @Override
    List<Agents> toEntity(List<AgentDTO> dtoList);

    @Override
    List<AgentDTO> toDto(List<Agents> entityList);
}
