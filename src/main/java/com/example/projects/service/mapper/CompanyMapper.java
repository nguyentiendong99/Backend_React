package com.example.projects.service.mapper;

import com.example.projects.domain.Company;
import com.example.projects.dto.CompanyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends EntityMapper<CompanyDTO , Company> {
    @Override
    Company toEntity(CompanyDTO dto);

    @Override
    CompanyDTO toDto(Company entity);

    @Override
    List<Company> toEntity(List<CompanyDTO> dtoList);

    @Override
    List<CompanyDTO> toDto(List<Company> entityList);
}
