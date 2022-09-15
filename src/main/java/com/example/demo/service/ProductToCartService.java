package com.example.demo.service;

import com.example.demo.entity.ProductToCart;
import com.example.demo.mapper.ProductToCartMapper;
import com.example.demo.productToCart.ProductToCartCreateDto;
import com.example.demo.productToCart.ProductToCartDto;
import com.example.demo.repository.ProductToCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductToCartService {
    private final ProductToCartRepository repository;
    private final ProductToCartMapper mapper;
    public ProductToCartService(ProductToCartRepository repository, ProductToCartMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<ProductToCartDto> getProductsToCart(){
        log.info("Получение всех товаров в корзине");
        return repository.findAll()
                .stream()
                .map(mapper::productToCartToDto).collect(Collectors.toList());
    }
    public ProductToCartDto getProductToCartById(Long id){
        log.info("Получение товара в корзине по Id");
        return mapper.productToCartToDto(repository.findById(id).orElse(null));
    }
    public void deleteProductToCart(Long id){
        log.info("Удаление продукта из корзины");
        repository.deleteById(id);
    }
    public ProductToCartDto createProductToCart(ProductToCartCreateDto request){
        log.info("Создание продукта в корзине");
        ProductToCart productToCart = mapper.dtoToProductToCart(request);
        repository.save(productToCart);
        return mapper.productToCartToDto(productToCart);
    }
}
