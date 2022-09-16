package com.example.demo.service;

import com.example.demo.stores.StoresCreateDto;
import com.example.demo.stores.StoresDto;
import com.example.demo.entity.Stores;
import com.example.demo.mapper.StoresMapper;
import com.example.demo.repository.StoresRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StoresService {
    private final StoresRepository repository;
    private final StoresMapper mapper;
    public StoresService(StoresRepository repository, StoresMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<StoresDto> getStores(){
        log.info("Получение всех магазинов");
        return repository.findAll()
                .stream()
                .map(mapper::storesToDto).collect(Collectors.toList());
    }
    public StoresDto getStoresById(Long id){
        log.info("Получение магазина по Id");
        return mapper.storesToDto(repository.findById(id).orElse(null));
    }
    public void deleteStores(Long id){
        log.info("Удаление магазина");
        repository.deleteById(id);
    }
    public StoresDto createStores(StoresCreateDto request){
        log.info("Создание магазина");
        Stores stores = mapper.dtoToStores(request);
        repository.save(stores);
        return mapper.storesToDto(stores);
    }
}
