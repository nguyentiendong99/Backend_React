package com.example.projects.web.rest;

import com.example.projects.dto.StockDTO;
import com.example.projects.service.StockService;
import com.example.projects.service.mapper.StockMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StockResource {
    private final StockService service;
    private final StockMapper stockMapper;
    public StockResource(StockService service, StockMapper stockMapper) {
        this.service = service;
        this.stockMapper = stockMapper;
    }
    @GetMapping("/stocks")
    public ResponseEntity<List<StockDTO>> getListStock(){
        List<StockDTO> list = stockMapper.toDto(service.getListStock());
        return ResponseEntity.ok(list);
    }
}
