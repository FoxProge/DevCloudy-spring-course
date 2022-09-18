package com.example.demo.service;

import com.example.demo.entity.ProductImage;
import com.example.demo.mapper.ProductImageMapper;
import com.example.demo.productImage.ProductImageCreateDto;
import com.example.demo.productImage.ProductImageDto;
import com.example.demo.repository.ProductImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductImageService {
    private final ProductImageRepository repository;
    private final ProductImageMapper mapper;
    public ProductImageService(ProductImageRepository repository, ProductImageMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<ProductImageDto> getProductImages(){
        log.info("Получение всех изображений для товара");
        return repository.findAll()
                .stream()
                .map(mapper::productImageToDto).collect(Collectors.toList());
    }
    public ProductImageDto getProductImageById(Long id){
        log.info("Получение изображения по Id");
        return mapper.productImageToDto(repository.findById(id).orElse(null));
    }
    public void deleteProductImage(Long id){
        log.info("Удаление изображения");
        repository.deleteById(id);
    }
    public ProductImageDto createProductImage(ProductImageCreateDto request){
        log.info("Создание изображения");
        ProductImage productImage = mapper.dtoToProductImage(request);
        repository.save(productImage);
        return mapper.productImageToDto(productImage);
    }
}
