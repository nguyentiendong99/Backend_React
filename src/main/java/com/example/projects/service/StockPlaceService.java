package com.example.projects.service;

import com.example.projects.domain.StockPlace;
import com.example.projects.dto.StockPlaceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StockPlaceService {
    Page<StockPlace> getListStockPlace(Pageable pageable);
    Page<StockPlace> getListStockPlaceByCompanyID(Integer id , Pageable pageable);
}
