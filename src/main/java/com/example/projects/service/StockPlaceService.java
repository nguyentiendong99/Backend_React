package com.example.projects.service;

import com.example.projects.domain.StockPlace;
import com.example.projects.dto.StockPlaceDTO;

import java.util.List;

public interface StockPlaceService {
    List<StockPlace> getListStockPlace();
}
