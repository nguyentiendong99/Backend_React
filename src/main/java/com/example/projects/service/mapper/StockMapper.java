package com.example.projects.service.mapper;

import com.example.projects.domain.Stock;
import com.example.projects.dto.StockDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockMapper extends EntityMapper<StockDTO , Stock> {
    @Override
    Stock toEntity(StockDTO dto);

    @Override
    StockDTO toDto(Stock entity);

    @Override
    List<Stock> toEntity(List<StockDTO> dtoList);

    @Override
    List<StockDTO> toDto(List<Stock> entityList);
}
