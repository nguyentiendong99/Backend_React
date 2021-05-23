package com.example.projects.web.rest;

import com.example.projects.dto.BrandDTO;
import com.example.projects.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BrandResource {
    private final BrandService brandService;

    public BrandResource(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("/brands")
    public ResponseEntity<List<BrandDTO>> getListBrand(){
        List<BrandDTO> list = brandService.getListBrand();
        return ResponseEntity.ok().body(list);
    }
}
