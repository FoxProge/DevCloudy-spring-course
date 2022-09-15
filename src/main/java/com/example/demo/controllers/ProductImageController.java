package com.example.demo.controllers;

import com.example.demo.productImage.ProductImageCreateDto;
import com.example.demo.productImage.ProductImageDto;
import com.example.demo.service.ProductImageService;
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
public class ProductImageController {
    private final ProductImageService service;
    @GetMapping(value = "/product-image")
    public List<ProductImageDto> getProductImages(){
        return service.getProductImages();
    }

    @GetMapping(
            value = "/product-image/{productImageId}",
            produces = {"application/json"})
    public ResponseEntity<ProductImageDto> getProductImage(
            @Parameter(description = "Идентификатор изображения", required = true)
            @PositiveOrZero @PathVariable("productImageId") Long productImageId){
        return ResponseEntity.ok(service.getProductImageById(productImageId));
    }

    @DeleteMapping(value = "/product-image/{productImageId}")
    public ResponseEntity<Void> deleteProductImage(
            @Parameter(description = "Идентификатор изображения", required = true)
            @PositiveOrZero @PathVariable("productImageId") Long productImageId){
        service.deleteProductImage(productImageId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/product-image/{productImageId}")
    public ResponseEntity<ProductImageDto> createProductImage(
            @Parameter(description = "Запрос на создание изображения")
            @Valid @RequestBody ProductImageCreateDto request){
        return new ResponseEntity<>(service.createProductImage(request), HttpStatus.CREATED);
    }
}
