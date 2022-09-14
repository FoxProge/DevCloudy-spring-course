package com.example.demo.controllers;

import com.example.demo.service.ProductService;
import com.example.demo.product.ProductCreateDto;
import com.example.demo.product.ProductDto;
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
public class ProductController {
    private final ProductService service;
    @GetMapping(value = "/product")
    public List<ProductDto> getProducts(){
        return service.getProducts();
    }

    @GetMapping(
            value = "/product/{productId}",
            produces = {"application/json"})
    public ResponseEntity<ProductDto> getProduct(
            @Parameter(description = "Идентификатор продукта", required = true)
            @PositiveOrZero @PathVariable("productId") Long productId){
        return ResponseEntity.ok(service.getProductById(productId));
    }

    @DeleteMapping(value = "/product/{productId}")
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "Идентификатор продукта", required = true)
            @PositiveOrZero @PathVariable("productId") Long productId){
        service.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/product/{productId}")
    public ResponseEntity<ProductDto> createProduct(
            @Parameter(description = "Запрос на создание продукта")
            @Valid @RequestBody ProductCreateDto request){
        return new ResponseEntity<>(service.createProduct(request), HttpStatus.CREATED);
    }
}
