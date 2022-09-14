package com.example.demo.mapper;

import com.example.demo.entity.Product;
import com.example.demo.product.ProductCreateDto;
import com.example.demo.product.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto productToProductDto(Product entity);
    Product productDtoToProduct(ProductCreateDto dto);
}
