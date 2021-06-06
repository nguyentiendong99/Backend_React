package com.example.projects.service;

import com.example.projects.domain.Stock;
import com.example.projects.dto.StockDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StockService {
    Page<Stock> getListStock(Pageable pageable);
    Page<Stock> getListStockByStockPlaceId(Integer id , Pageable pageable);
}
