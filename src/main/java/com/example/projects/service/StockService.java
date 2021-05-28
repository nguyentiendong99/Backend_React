package com.example.projects.service;

import com.example.projects.domain.Stock;
import com.example.projects.dto.StockDTO;

import java.util.List;

public interface StockService {
    List<Stock> getListStock();
}
