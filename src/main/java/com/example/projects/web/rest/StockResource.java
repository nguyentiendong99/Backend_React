package com.example.projects.web.rest;

import com.example.projects.dto.StockDTO;
import com.example.projects.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StockResource {
    private final StockService service;

    public StockResource(StockService service) {
        this.service = service;
    }
    @GetMapping("/stock")
    public ResponseEntity<List<StockDTO>> getListStock(){
        List<StockDTO> list = service.getListStock();
        return ResponseEntity.ok().body(list);
    }
}
