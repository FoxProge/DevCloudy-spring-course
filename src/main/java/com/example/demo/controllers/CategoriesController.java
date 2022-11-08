package com.example.demo.controllers;

import com.example.demo.categories.CategoriesCreateDto;
import com.example.demo.categories.CategoriesDto;
import com.example.demo.service.CategoriesService;
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
@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
@Getter
@Setter
public class CategoriesController {

    private final CategoriesService service;
    @GetMapping(value = "/categories")
    public List<CategoriesDto> getCategories(){
        return service.getCategories();
    }

    @GetMapping(
            value = "/categories/{categoryId}",
            produces = {"application/json"})
    public ResponseEntity<CategoriesDto> getCategory(
            @Parameter(description = "Идентификатор категории", required = true)
            @PositiveOrZero @PathVariable("categoryId") Long categoryId){
        return ResponseEntity.ok(service.getCategoryById(categoryId));
    }

    @DeleteMapping(value = "/categories/delete/{categoryId}")
    public ResponseEntity<Void> deleteCategory(
            @Parameter(description = "Идентификатор категории", required = true)
            @PositiveOrZero @PathVariable("categoryId") Long categoryId){
        service.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/categories/create")
    public ResponseEntity<CategoriesDto> createCategory(
            @Parameter(description = "Запрос на создание категории")
            @Valid @RequestBody CategoriesCreateDto request){
        return new ResponseEntity<>(service.createCategory(request), HttpStatus.CREATED);
    }
}
