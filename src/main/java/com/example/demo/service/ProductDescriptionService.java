package com.example.demo.service;

import com.example.demo.categories.CategoriesCreateDto;
import com.example.demo.categories.CategoriesDto;
import com.example.demo.entity.Categories;
import com.example.demo.entity.ProductDescription;
import com.example.demo.mapper.ProductDescriptionMapper;
import com.example.demo.productDescription.ProductDescriptionCreateDto;
import com.example.demo.productDescription.ProductDescriptionDto;
import com.example.demo.repository.ProductDescriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductDescriptionService {
    private final ProductDescriptionRepository repository;
    private final ProductDescriptionMapper mapper;
    public ProductDescriptionService(ProductDescriptionRepository repository, ProductDescriptionMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<ProductDescriptionDto> getProductDescriptions(){
        log.info("Получение всех описаний продуктов");
        return repository.findAll()
                .stream()
                .map(mapper::productDescriptionToDto).collect(Collectors.toList());
    }
    public ProductDescriptionDto getProductDescriptionById(Long id){
        log.info("Получение описания продукта по Id");
        return mapper.productDescriptionToDto(repository.findById(id).orElse(null));
    }
    public void deleteProductDescription(Long id){
        log.info("Удаление описания продукта");
        repository.deleteById(id);
    }
    public ProductDescriptionDto createProductDescription(ProductDescriptionCreateDto request){
        log.info("Создание описания продукта");
        ProductDescription productDescription = mapper.dtoToProductDescription(request);
        repository.save(productDescription);
        return mapper.productDescriptionToDto(productDescription);
    }
}
