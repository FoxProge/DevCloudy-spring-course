package com.example.demo.mapper;

import com.example.demo.stockStatus.StockStatusCreateDto;
import com.example.demo.stockStatus.StockStatusDto;
import com.example.demo.entity.StockStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockStatusMapper {
    StockStatusDto stockStatusToDto(StockStatus entity);
    StockStatus dtoToStockStatus(StockStatusCreateDto dto);
}
