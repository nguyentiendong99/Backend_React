package com.example.projects.web.rest;

import com.example.projects.domain.Stock;
import com.example.projects.dto.StockDTO;
import com.example.projects.dto.StockPlaceDTO;
import com.example.projects.service.StockService;
import com.example.projects.service.mapper.StockMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StockResource {
    private final StockService service;
    private final StockMapper stockMapper;
    public StockResource(StockService service, StockMapper stockMapper) {
        this.service = service;
        this.stockMapper = stockMapper;
    }
    @GetMapping("/stocks")
    public ResponseEntity<Page<Stock>> getListStock(int pageNumber , int pageSize){
        Page<Stock> page = service.getListStock(
                PageRequest.of(pageNumber ,pageSize)
        );
        return ResponseEntity.ok(page);
    }
    @GetMapping("/stocks/stockplaces/{id}")
    public ResponseEntity<Page<Stock>> getListStockByStockPlaceID(@PathVariable("id") Integer id ,
                                                                  int pageNumber , int pageSize){
        Page<Stock> page = service.getListStockByStockPlaceId(id , PageRequest.of(
                pageNumber ,pageSize
        ));
        return ResponseEntity.ok().body(page);
    }
}
