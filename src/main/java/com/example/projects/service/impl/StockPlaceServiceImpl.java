package com.example.projects.service.impl;

import com.example.projects.dto.StockPlaceDTO;
import com.example.projects.repository.StockPlaceRepository;
import com.example.projects.service.StockPlaceService;
import com.example.projects.service.mapper.StockPlaceMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StockPlaceServiceImpl implements StockPlaceService {
    private final StockPlaceRepository stockPlaceRepository;
    private final StockPlaceMapper stockPlaceMapper;

    public StockPlaceServiceImpl(StockPlaceRepository stockPlaceRepository, StockPlaceMapper stockPlaceMapper) {
        this.stockPlaceRepository = stockPlaceRepository;
        this.stockPlaceMapper = stockPlaceMapper;
    }

    @Override
    public List<StockPlaceDTO> getListStockPlace() {
        return stockPlaceMapper.toDto(stockPlaceRepository.findAll());
    }
}
