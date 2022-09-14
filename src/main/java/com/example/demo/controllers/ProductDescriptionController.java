package com.example.demo.controllers;

import com.example.demo.productDescription.ProductDescriptionCreateDto;
import com.example.demo.productDescription.ProductDescriptionDto;
import com.example.demo.service.ProductDescriptionService;
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
public class ProductDescriptionController {
    private final ProductDescriptionService service;
    @GetMapping(value = "/product-description")
    public List<ProductDescriptionDto> getProductDescriptions(){
        return service.getProductDescriptions();
    }

    @GetMapping(
            value = "/product-description/{productDescriptionId}",
            produces = {"application/json"})
    public ResponseEntity<ProductDescriptionDto> getProductDescription(
            @Parameter(description = "Идентификатор описания продукта", required = true)
            @PositiveOrZero @PathVariable("productDescriptionId") Long productDescriptionId){
        return ResponseEntity.ok(service.getProductDescriptionById(productDescriptionId));
    }

    @DeleteMapping(value = "/product-description/{productDescriptionId}")
    public ResponseEntity<Void> deleteProductDescription(
            @Parameter(description = "Идентификатор описания продукта", required = true)
            @PositiveOrZero @PathVariable("productDescriptionId") Long productDescriptionId){
        service.deleteProductDescription(productDescriptionId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/product-description/{productDescriptionId}")
    public ResponseEntity<ProductDescriptionDto> createProductDescription(
            @Parameter(description = "Запрос на создание описания продукта")
            @Valid @RequestBody ProductDescriptionCreateDto request){
        return new ResponseEntity<>(service.createProductDescription(request), HttpStatus.CREATED);
    }
}
