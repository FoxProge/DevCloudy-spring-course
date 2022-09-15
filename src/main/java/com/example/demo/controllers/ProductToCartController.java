package com.example.demo.controllers;

import com.example.demo.productToCart.ProductToCartCreateDto;
import com.example.demo.productToCart.ProductToCartDto;
import com.example.demo.service.ProductToCartService;
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
public class ProductToCartController {
    private final ProductToCartService service;
    @GetMapping(value = "/product-to-cart")
    public List<ProductToCartDto> getProductsToCart(){
        return service.getProductsToCart();
    }

    @GetMapping(
            value = "/product-to-cart/{productToCartId}",
            produces = {"application/json"})
    public ResponseEntity<ProductToCartDto> getProductToCart(
            @Parameter(description = "Идентификатор корзины", required = true)
            @PositiveOrZero @PathVariable("productToCartId") Long productToCartId){
        return ResponseEntity.ok(service.getProductToCartById(productToCartId));
    }

    @DeleteMapping(value = "/product-to-cart/{productToCartId}")
    public ResponseEntity<Void> deleteProductToCart(
            @Parameter(description = "Идентификатор корзины", required = true)
            @PositiveOrZero @PathVariable("productToCartId") Long productToCartId){
        service.deleteProductToCart(productToCartId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/product-to-cart/{productToCartId}")
    public ResponseEntity<ProductToCartDto> createProductToCart(
            @Parameter(description = "Запрос на создание товара в корзине")
            @Valid @RequestBody ProductToCartCreateDto request){
        return new ResponseEntity<>(service.createProductToCart(request), HttpStatus.CREATED);
    }
}
