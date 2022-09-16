package com.example.demo.service;

import com.example.demo.deliveryMethod.DeliveryMethodCreateDto;
import com.example.demo.deliveryMethod.DeliveryMethodDto;
import com.example.demo.entity.DeliveryMethod;
import com.example.demo.mapper.DeliveryMethodMapper;
import com.example.demo.repository.DeliveryMethodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DeliveryMethodService {
    private final DeliveryMethodRepository repository;
    private final DeliveryMethodMapper mapper;
    public DeliveryMethodService(DeliveryMethodRepository repository, DeliveryMethodMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<DeliveryMethodDto> getDeliveryMethods(){
        log.info("Получение всех видов доставки");
        return repository.findAll()
                .stream()
                .map(mapper::deliveryMethodToDto).collect(Collectors.toList());
    }
    public DeliveryMethodDto getDeliveryMethodById(Long id){
        log.info("Получение метода доставки по Id");
        return mapper.deliveryMethodToDto(repository.findById(id).orElse(null));
    }
    public void deleteDeliveryMethod(Long id){
        log.info("Удаление метода доставки");
        repository.deleteById(id);
    }
    public DeliveryMethodDto createDeliveryMethod(DeliveryMethodCreateDto request){
        log.info("Создание методоа доставки");
        DeliveryMethod deliveryMethod = mapper.dtoToDeliveryMethod(request);
        repository.save(deliveryMethod);
        return mapper.deliveryMethodToDto(deliveryMethod);
    }
}
