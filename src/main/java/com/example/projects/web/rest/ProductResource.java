package com.example.projects.web.rest;

import com.example.projects.domain.Product;
import com.example.projects.dto.ProductDTO;
import com.example.projects.dto.UserDTO;
import com.example.projects.service.ProductService;
import com.example.projects.web.rest.util.PaginationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getListProduct(int pageNumber , int pageSize ,String sortBy ,String sortDir){
        Page<Product> list = productService.getListProduct(
                PageRequest.of(
                        pageNumber , pageSize
                        ,sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        );
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
    @DeleteMapping("/products/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/products/search")
    public ResponseEntity<List<ProductDTO>> search(@RequestParam MultiValueMap<String, String> queryParams,
                                                Pageable pageable) {
        Page<ProductDTO> page = productService.search(queryParams, pageable);
        HttpHeaders headers = PaginationUtil
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequestUri(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
