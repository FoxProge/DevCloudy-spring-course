package com.example.demo.controllers;

import com.example.demo.productToCategory.ProductToCategoryDto;
import com.example.demo.service.ProductToCategoryService;
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
public class ProductToCategoryController {
    private final ProductToCategoryService service;
    @GetMapping(value = "/product-to-category")
    public List<ProductToCategoryDto> getProductsToCategories(){
        return service.getProductToCategory();
    }

    @GetMapping(
            value = "/product-to-category/{productToCategoryId}",
            produces = {"application/json"})
    public ResponseEntity<ProductToCategoryDto> getProductToCategory(
            @Parameter(description = "Идентификатор товара в категории", required = true)
            @PositiveOrZero @PathVariable("productToCategoryId") Long productToCategoryId){
        return ResponseEntity.ok(service.getProductToCategoryById(productToCategoryId));
    }

    @DeleteMapping(value = "/product-to-category/{productToCategoryId}")
    public ResponseEntity<Void> deleteProductToCategory(
            @Parameter(description = "Идентификатор товара в категории", required = true)
            @PositiveOrZero @PathVariable("productToCategoryId") Long productToCategoryId){
        service.deleteProductToCategory(productToCategoryId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/product-to-category/{productToCategoryId}")
    public ResponseEntity<ProductToCategoryDto> createProductToCategory(
            @Parameter(description = "Запрос на задание товара в категории")
            @Valid @RequestBody ProductToCategoryDto request){
        return new ResponseEntity<>(service.createProductToCategory(request), HttpStatus.CREATED);
    }
}
