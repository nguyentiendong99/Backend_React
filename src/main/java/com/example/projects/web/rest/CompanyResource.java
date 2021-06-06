package com.example.projects.web.rest;

import com.example.projects.dto.CompanyDTO;
import com.example.projects.service.CompanyService;
import com.example.projects.service.mapper.CompanyMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CompanyResource {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;
    public CompanyResource(CompanyService companyService, CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }
    @GetMapping("/company")
    public ResponseEntity<List<CompanyDTO>> getCompany(){
        List<CompanyDTO> companyDTO = companyMapper.toDto(companyService.getCompany());
        return ResponseEntity.ok().body(companyDTO);
    }
}
