package com.example.demo.service;

import com.example.demo.productToStore.ProductToStoreCreateDto;
import com.example.demo.productToStore.ProductToStoreDto;
import com.example.demo.entity.ProductToStore;
import com.example.demo.mapper.ProductToStoreMapper;
import com.example.demo.repository.ProductToStoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductToStoreService {
    private final ProductToStoreRepository repository;
    private final ProductToStoreMapper mapper;
    public ProductToStoreService(ProductToStoreRepository repository, ProductToStoreMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<ProductToStoreDto> getProductToStores(){
        log.info("Получение всех товаров в магазинах");
        return repository.findAll()
                .stream()
                .map(mapper::productToStoreToDto).collect(Collectors.toList());
    }
    public ProductToStoreDto getProductToStoreById(Long id){
        log.info("Получение товаров в магазине по Id");
        return mapper.productToStoreToDto(repository.findById(id).orElse(null));
    }
    public void deleteProductToStore(Long id){
        log.info("Удаление товаров в магазине");
        repository.deleteById(id);
    }
    public ProductToStoreDto createProductToStore(ProductToStoreCreateDto request){
        log.info("Создание товаров в магазине");
        ProductToStore productToStore = mapper.dtoToProductToStore(request);
        repository.save(productToStore);
        return mapper.productToStoreToDto(productToStore);
    }
}
