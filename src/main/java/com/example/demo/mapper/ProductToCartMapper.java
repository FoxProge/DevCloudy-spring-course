package com.example.demo.mapper;

import com.example.demo.entity.ProductToCart;
import com.example.demo.productToCart.ProductToCartCreateDto;
import com.example.demo.productToCart.ProductToCartDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductToCartMapper {
    ProductToCartDto productToCartToDto(ProductToCart entity);
    ProductToCart dtoToProductToCart(ProductToCartCreateDto dto);
}
