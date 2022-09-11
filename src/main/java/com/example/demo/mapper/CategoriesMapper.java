package com.example.demo.mapper;

import com.example.demo.categories.CategoriesDto;
import com.example.demo.entity.Categories;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriesMapper {
    CategoriesDto categoriesToCategoriesDto(Categories entity);
    Categories categoriesDtoToCategories(CategoriesDto dto);
}
