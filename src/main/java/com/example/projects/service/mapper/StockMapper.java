package com.example.projects.service.mapper;

import com.example.projects.domain.Stock;
import com.example.projects.dto.StockDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockMapper extends EntityMapper<StockDTO , Stock> {
    Stock toEntity(StockDTO dto);

    StockDTO toDto(Stock entity);

    List<Stock> toEntity(List<StockDTO> dtoList);

    List<StockDTO> toDto(List<Stock> entityList);
}
