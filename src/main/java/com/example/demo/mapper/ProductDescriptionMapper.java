package com.example.demo.mapper;

import com.example.demo.entity.ProductDescription;
import com.example.demo.productDescription.ProductDescriptionCreateDto;
import com.example.demo.productDescription.ProductDescriptionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDescriptionMapper {
    ProductDescriptionDto productDescriptionToDto(ProductDescription entity);
    ProductDescription dtoToProductDescription(ProductDescriptionCreateDto dto);
}
