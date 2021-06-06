package com.example.projects.web.rest;

import com.example.projects.domain.StockPlace;
import com.example.projects.dto.StockPlaceDTO;
import com.example.projects.service.StockPlaceService;
import com.example.projects.service.mapper.StockPlaceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StockPlaceResource {
    private final StockPlaceService stockPlaceService;
    private final StockPlaceMapper stockPlaceMapper;
    public StockPlaceResource(StockPlaceService stockPlaceService, StockPlaceMapper stockPlaceMapper) {
        this.stockPlaceService = stockPlaceService;
        this.stockPlaceMapper = stockPlaceMapper;
    }

    @GetMapping("/stockplaces")
    public ResponseEntity<Page<StockPlace>> getListStockPlace(int pageNumber , int pageSize){
        Page<StockPlace> page = stockPlaceService.getListStockPlace(
                PageRequest.of(
                        pageNumber , pageSize
                )
        );
        return ResponseEntity.ok().body(page);
    }
    @GetMapping("stockplaces/company/{id}")
    public ResponseEntity<Page<StockPlace>> getListStockPlaceByCompanyID(@PathVariable("id") Integer id ,
                                                                         int pageNumber , int pageSize){
        Page<StockPlace> page = stockPlaceService.getListStockPlaceByCompanyID(id ,
                PageRequest.of(
                        pageNumber , pageSize
                ));
        return ResponseEntity.ok().body(page);
    }
}
