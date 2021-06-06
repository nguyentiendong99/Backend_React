package com.example.projects.web.rest;

import com.example.projects.domain.Brand;
import com.example.projects.dto.BrandDTO;
import com.example.projects.service.BrandService;
import com.example.projects.service.mapper.BrandMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BrandResource {
    private final BrandService brandService;
    private final BrandMapper brandMapper;
    public BrandResource(BrandService brandService, BrandMapper brandMapper) {
        this.brandService = brandService;
        this.brandMapper = brandMapper;
    }
    @GetMapping("/brands")
    public ResponseEntity<Page<Brand>> getListBrand(int pageNumber , int pageSize){
        Page<Brand> page = brandService.getListBrand(
                PageRequest.of(
                        pageNumber , pageSize
                )
        );
        return ResponseEntity.ok(page);
    }
    @GetMapping("/brands/agents/{agentId}")
    public ResponseEntity<Page<Brand>> getListBrandByAgentId(@PathVariable("agentId") Integer agentId ,
                                                             int pageNumber , int pageSize){
        Page<Brand> page = brandService.getListBrandByAgentId(
                agentId , PageRequest.of(pageNumber , pageSize)
        );
        return ResponseEntity.ok().body(page);
    }
}
