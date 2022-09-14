package com.example.demo.service;

import com.example.demo.entity.Manufacturer;
import com.example.demo.manufacturer.ManufacturerCreateDto;
import com.example.demo.manufacturer.ManufacturerDto;
import com.example.demo.mapper.ManufacturerMapper;
import com.example.demo.repository.ManufacturerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ManufacturerService {
    private final ManufacturerRepository repository;
    private final ManufacturerMapper mapper;
    public ManufacturerService(ManufacturerRepository repository, ManufacturerMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<ManufacturerDto> getManufacturers(){
        log.info("Получение всех изготовителей");
        return repository.findAll()
                .stream()
                .map(mapper::manufacturerToDto).collect(Collectors.toList());
    }
    public ManufacturerDto getManufacturerById(Long id){
        log.info("Получение изготовителя по Id");
        return mapper.manufacturerToDto(repository.findById(id).orElse(null));
    }
    public void deleteManufacturer(Long id){
        log.info("Удаление изготовителяя");
        repository.deleteById(id);
    }
    public ManufacturerDto createManufacturer(ManufacturerCreateDto request){
        log.info("Создание категории");
        Manufacturer manufacturer = mapper.dtoToManufacturer(request);
        repository.save(manufacturer);
        return mapper.manufacturerToDto(manufacturer);
    }
}
