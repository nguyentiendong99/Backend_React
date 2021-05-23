package com.example.projects.service.mapper;

import com.example.projects.domain.Company;
import com.example.projects.dto.CompanyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends EntityMapper<CompanyDTO , Company> {
    Company toEntity(CompanyDTO dto);

    CompanyDTO toDto(Company entity);

    List<Company> toEntity(List<CompanyDTO> dtoList);

    List<CompanyDTO> toDto(List<Company> entityList);
}
