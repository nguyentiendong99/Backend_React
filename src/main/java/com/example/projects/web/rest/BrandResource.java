package com.example.projects.web.rest;

import com.example.projects.dto.BrandDTO;
import com.example.projects.service.BrandService;
import com.example.projects.service.mapper.BrandMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BrandResource {
    private final BrandService brandService;
    private final BrandMapper brandMapper;
    public BrandResource(BrandService brandService, BrandMapper brandMapper) {
        this.brandService = brandService;
        this.brandMapper = brandMapper;
    }
    @GetMapping("/brands")
    public ResponseEntity<List<BrandDTO>> getListBrand(){
        List<BrandDTO> list = brandMapper.toDto(brandService.getListBrand());
        return ResponseEntity.ok(list);
    }
}
