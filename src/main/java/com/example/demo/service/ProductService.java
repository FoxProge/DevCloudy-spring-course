package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.product.ProductCreateDto;
import com.example.demo.product.ProductDto;
import com.example.demo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    public ProductService(ProductRepository repository, ProductMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<ProductDto> getProducts(){
        log.info("Получение списка всех продуктов");
        return repository.findAll()
                .stream()
                .map(mapper::productToProductDto).collect(Collectors.toList());
    }
    public ProductDto getProductById(Long id){
        log.info("Получение продукта по Id");
        return mapper.productToProductDto(repository.findById(id).orElse(null));
    }
    public ProductDto getProductByCategory(Long categoryId){
        log.info("Получение продукта по его Id категории");
        return mapper.productToProductDto(repository.getByCategoryId(categoryId).orElse(null));
    }
    public void deleteProduct(Long id){
        log.info("Удаление продукта");
        repository.deleteById(id);
    }
    public ProductDto createProduct(ProductCreateDto request){
        log.info("Создание продукта");
        Product product = mapper.productDtoToProduct(request);
        repository.save(product);
        return mapper.productToProductDto(product);
    }
}
