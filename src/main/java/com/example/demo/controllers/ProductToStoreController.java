package com.example.demo.controllers;

import com.example.demo.productToStore.ProductToStoreCreateDto;
import com.example.demo.productToStore.ProductToStoreDto;
import com.example.demo.service.ProductToStoreService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@AllArgsConstructor
@Getter
@Setter
public class ProductToStoreController {
    private final ProductToStoreService service;
    @GetMapping(value = "/product-to-store")
    public List<ProductToStoreDto> getProductToStores(){
        return service.getProductToStores();
    }

    @GetMapping(
            value = "/product-to-store/{productToStoreId}",
            produces = {"application/json"})
    public ResponseEntity<ProductToStoreDto> getProductToStore(
            @Parameter(description = "Идентификатор списка продуктов в магазине", required = true)
            @PositiveOrZero @PathVariable("productToStoreId") Long productToStoreId){
        return ResponseEntity.ok(service.getProductToStoreById(productToStoreId));
    }

    @DeleteMapping(value = "/product-to-store/{productToStoreId}")
    public ResponseEntity<Void> deleteProductToStore(
            @Parameter(description = "Идентификатор списка продуктов в магазине", required = true)
            @PositiveOrZero @PathVariable("productToStoreId") Long productToStoreId){
        service.deleteProductToStore(productToStoreId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/product-to-store/{productToStoreId}")
    public ResponseEntity<ProductToStoreDto> createProductToStore(
            @Parameter(description = "Запрос на создание списка продуктов в магазине")
            @Valid @RequestBody ProductToStoreCreateDto request){
        return new ResponseEntity<>(service.createProductToStore(request), HttpStatus.CREATED);
    }
}
