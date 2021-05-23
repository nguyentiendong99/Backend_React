package com.example.projects.service.mapper;

import com.example.projects.domain.Agents;
import com.example.projects.dto.AgentDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgentMapper extends EntityMapper<AgentDTO , Agents> {
    Agents toEntity(AgentDTO dto);

    AgentDTO toDto(Agents entity);

    List<Agents> toEntity(List<AgentDTO> dtoList);

    List<AgentDTO> toDto(List<Agents> entityList);
}
