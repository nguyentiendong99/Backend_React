package com.example.projects.web.rest;

import com.example.projects.dto.StockPlaceDTO;
import com.example.projects.service.StockPlaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StockPlaceResource {
    private final StockPlaceService stockPlaceService;

    public StockPlaceResource(StockPlaceService stockPlaceService) {
        this.stockPlaceService = stockPlaceService;
    }

    @GetMapping("/stockplaces")
    public ResponseEntity<List<StockPlaceDTO>> getListStockPlace(){
        List<StockPlaceDTO> list = stockPlaceService.getListStockPlace();
        return ResponseEntity.ok().body(list);
    }
}
