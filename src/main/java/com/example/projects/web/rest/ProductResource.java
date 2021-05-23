package com.example.projects.web.rest;

import com.example.projects.dto.ProductDTO;
import com.example.projects.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Integer id){
        ProductDTO productDTO = productService.getProductById(id);
        return ResponseEntity.ok().body(productDTO);
    }
    @PostMapping("/products")
    public ResponseEntity<ProductDTO> create(@RequestBody @Valid ProductDTO productDTO) {
        ProductDTO result = productService.Save(productDTO);
        return ResponseEntity.ok().body(result);
    }
    @PutMapping("/products")
    public ResponseEntity<ProductDTO> update(@RequestBody @Valid ProductDTO productDTO) {
        ProductDTO result = productService.Update(productDTO);
        return ResponseEntity.ok().body(result);
    }
}
