package com.example.projects.service.impl;

import com.example.projects.dto.CompanyDTO;
import com.example.projects.repository.CompanyRepository;
import com.example.projects.service.CompanyService;
import com.example.projects.service.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyDTO> getCompany() {
        return companyMapper.toDto(companyRepository.findAll());
    }
}
