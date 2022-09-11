package com.example.demo.categories.controllers;

import com.example.demo.categories.CategoriesDto;
import com.example.demo.service.CategoriesService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Getter
@Setter
public class TestController {

    private final CategoriesService service;
    @GetMapping(value="/categories")
    public List<CategoriesDto> getCategories(){
        return service.getCategories();
    }
}
