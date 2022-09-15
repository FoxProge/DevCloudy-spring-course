package com.example.demo.mapper;

import com.example.demo.entity.ProductImage;
import com.example.demo.productImage.ProductImageCreateDto;
import com.example.demo.productImage.ProductImageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {
    ProductImageDto productImageToDto(ProductImage entity);
    ProductImage dtoToProductImage(ProductImageCreateDto dto);
}
