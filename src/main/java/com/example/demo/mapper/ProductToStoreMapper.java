package com.example.demo.mapper;

import com.example.demo.productToStore.ProductToStoreCreateDto;
import com.example.demo.productToStore.ProductToStoreDto;
import com.example.demo.entity.ProductToStore;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductToStoreMapper {
    ProductToStoreDto productToStoreToDto(ProductToStore entity);
    ProductToStore dtoToProductToStore(ProductToStoreCreateDto dto);
}
