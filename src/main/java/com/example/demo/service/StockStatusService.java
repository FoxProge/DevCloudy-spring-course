package com.example.demo.service;

import com.example.demo.stockStatus.StockStatusCreateDto;
import com.example.demo.stockStatus.StockStatusDto;
import com.example.demo.entity.StockStatus;
import com.example.demo.mapper.StockStatusMapper;
import com.example.demo.repository.StockStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StockStatusService {
    private final StockStatusRepository repository;
    private final StockStatusMapper mapper;
    public StockStatusService(StockStatusRepository repository, StockStatusMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<StockStatusDto> getStockStatuses(){
        log.info("Получение всех состояния запасов");
        return repository.findAll()
                .stream()
                .map(mapper::stockStatusToDto).collect(Collectors.toList());
    }
    public StockStatusDto getStockStatusById(Long id){
        log.info("Получение состояний запасов по Id");
        return mapper.stockStatusToDto(repository.findById(id).orElse(null));
    }
    public void deleteStockStatus(Long id){
        log.info("Удаление состояния запасов");
        repository.deleteById(id);
    }
    public StockStatusDto createStockStatus(StockStatusCreateDto request){
        log.info("Создание состояния запасов");
        StockStatus stockStatus = mapper.dtoToStockStatus(request);
        repository.save(stockStatus);
        return mapper.stockStatusToDto(stockStatus);
    }
}
