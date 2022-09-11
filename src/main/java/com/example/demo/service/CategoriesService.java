package com.example.demo.service;

import com.example.demo.categories.CategoriesDto;
import com.example.demo.entity.Categories;
import com.example.demo.mapper.CategoriesMapper;
import com.example.demo.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesService {
    private final CategoriesRepository repository;
    private final CategoriesMapper mapper;

    public List<CategoriesDto> getCategories(){
        return repository.findAll()
                .stream()
                .map(mapper::categoriesToCategoriesDto).collect(Collectors.toList());
    }

    public CategoriesService(CategoriesRepository repository, CategoriesMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
}
