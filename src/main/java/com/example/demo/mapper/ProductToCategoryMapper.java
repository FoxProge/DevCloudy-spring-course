package com.example.demo.mapper;


import com.example.demo.entity.ProductToCategory;
import com.example.demo.productToCategory.ProductToCategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductToCategoryMapper {
    ProductToCategoryDto productToCategoryToDto(ProductToCategory entity);
    ProductToCategory dtoToProductToCategory(ProductToCategoryDto dto);
}
