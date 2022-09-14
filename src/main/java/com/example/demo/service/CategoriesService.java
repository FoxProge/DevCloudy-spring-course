package com.example.demo.service;

import com.example.demo.categories.CategoriesCreateDto;
import com.example.demo.categories.CategoriesDto;
import com.example.demo.entity.Categories;
import com.example.demo.mapper.CategoriesMapper;
import com.example.demo.repository.CategoriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoriesService {
    private final CategoriesRepository repository;
    private final CategoriesMapper mapper;
    public CategoriesService(CategoriesRepository repository, CategoriesMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<CategoriesDto> getCategories(){
        log.info("Получение всех категорий");
        return repository.findAll()
                .stream()
                .map(mapper::categoriesToCategoriesDto).collect(Collectors.toList());
    }
    public CategoriesDto getCategoryById(Long id){
        log.info("Получение категории по Id");
        return mapper.categoriesToCategoriesDto(repository.findById(id).orElse(null));
    }
    public void deleteCategory(Long id){
        log.info("Удаление категории");
        repository.deleteById(id);
    }
    public CategoriesDto createCategory(CategoriesCreateDto request){
        log.info("Создание категории");
        Categories categories = mapper.categoriesDtoToCategories(request);
        repository.save(categories);
        return mapper.categoriesToCategoriesDto(categories);
    }
}
