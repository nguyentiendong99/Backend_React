package com.example.projects.service.mapper;

import com.example.projects.domain.StockPlace;
import com.example.projects.dto.StockPlaceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockPlaceMapper extends EntityMapper<StockPlaceDTO , StockPlace> {
    @Override
    StockPlace toEntity(StockPlaceDTO dto);

    @Override
    StockPlaceDTO toDto(StockPlace entity);

    @Override
    List<StockPlace> toEntity(List<StockPlaceDTO> dtoList);

    @Override
    List<StockPlaceDTO> toDto(List<StockPlace> entityList);
}
