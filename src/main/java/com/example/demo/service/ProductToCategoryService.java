package com.example.demo.service;

import com.example.demo.entity.ProductToCategory;
import com.example.demo.mapper.ProductToCategoryMapper;
import com.example.demo.productToCategory.ProductToCategoryDto;
import com.example.demo.repository.ProductToCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductToCategoryService {
    private final ProductToCategoryRepository repository;
    private final ProductToCategoryMapper mapper;
    public ProductToCategoryService(ProductToCategoryRepository repository, ProductToCategoryMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<ProductToCategoryDto> getProductToCategory(){
        log.info("Получение всех товаров в категории");
        return repository.findAll()
                .stream()
                .map(mapper::productToCategoryToDto).collect(Collectors.toList());
    }
    public ProductToCategoryDto getProductToCategoryById(Long id){
        log.info("Получение товара в категории по Id");
        return mapper.productToCategoryToDto(repository.findById(id).orElse(null));
    }
    public void deleteProductToCategory(Long id){
        log.info("Удаление товара в категории");
        repository.deleteById(id);
    }
    public ProductToCategoryDto createProductToCategory(ProductToCategoryDto request){
        log.info("Создание товара в категории");
        ProductToCategory productToCategory = mapper.dtoToProductToCategory(request);
        repository.save(productToCategory);
        return mapper.productToCategoryToDto(productToCategory);
    }
}
