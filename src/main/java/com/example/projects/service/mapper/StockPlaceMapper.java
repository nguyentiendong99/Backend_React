package com.example.projects.service.mapper;

import com.example.projects.domain.StockPlace;
import com.example.projects.dto.StockPlaceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockPlaceMapper extends EntityMapper<StockPlaceDTO , StockPlace> {
    StockPlace toEntity(StockPlaceDTO dto);

    StockPlaceDTO toDto(StockPlace entity);

    List<StockPlace> toEntity(List<StockPlaceDTO> dtoList);

    List<StockPlaceDTO> toDto(List<StockPlace> entityList);
}
