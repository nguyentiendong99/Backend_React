package com.example.projects.web.rest;

import com.example.projects.dto.CompanyDTO;
import com.example.projects.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CompanyResource {
    private final CompanyService companyService;

    public CompanyResource(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping("/company")
    public ResponseEntity<List<CompanyDTO>> getCompany(){
        List<CompanyDTO> companyDTO = companyService.getCompany();
        return ResponseEntity.ok().body(companyDTO);
    }
}
