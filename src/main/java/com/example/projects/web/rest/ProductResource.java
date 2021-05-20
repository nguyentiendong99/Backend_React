package com.example.projects.web.rest;

import com.example.projects.dto.ProductDTO;
import com.example.projects.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getListProduct(){
        List<ProductDTO> list = productService.getListProduct();
        return ResponseEntity.ok().body(list);
    }
}
