package com.example.projects.web.rest;

import com.example.projects.domain.Product;
import com.example.projects.dto.ProductDTO;
import com.example.projects.export.ProductExcelExporter;
import com.example.projects.export.ProductPDFExporter;
import com.example.projects.service.ProductService;
import com.example.projects.service.mapper.ProductMapper;
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

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductResource {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductResource(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
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
    @GetMapping("products/category/{categoryId}")
    public ResponseEntity<Page<Product>> getListProductByCategory(
            @PathVariable("categoryId") Integer categoryId ,
             int pageNumber , int pageSize){
        Page<Product> list = productService.getListProductByCategoryID(categoryId , PageRequest.of(
                pageNumber , pageSize
        ));
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
    @GetMapping("products/exportPdf")
    public void exportPdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
        String currentDateTime = format.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=products_" + currentDateTime + ".pdf";
        response.setHeader(headerKey , headerValue);
        List<Product> products = productService.findAll();
        ProductPDFExporter exporter = new ProductPDFExporter(products);
        exporter.Export(response);
    }
    @GetMapping("products/exportExcel")
    public void ExportExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
        String currentDateTime = dateFormater.format(new Date());
        String fileName = "product_" + currentDateTime + ".xlsx";
        String headerValue = "attachment ; filename=" + fileName;
        response.setHeader(headerKey, headerValue);
        List<Product> list = productService.findAll();
        ProductExcelExporter excelExporter = new ProductExcelExporter(list);
        excelExporter.Export(response);
    }
}
