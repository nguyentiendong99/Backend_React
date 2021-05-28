package com.example.projects.service.impl;

import com.example.projects.domain.Stock;
import com.example.projects.dto.StockDTO;
import com.example.projects.repository.StockRepository;
import com.example.projects.service.StockService;
import com.example.projects.service.mapper.StockMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    public StockServiceImpl(StockRepository stockRepository, StockMapper stockMapper) {
        this.stockRepository = stockRepository;
        this.stockMapper = stockMapper;
    }

    @Override
    public List<Stock> getListStock() {
        return stockRepository.getListStock();
    }
}
