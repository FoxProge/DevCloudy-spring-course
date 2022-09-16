package com.example.demo.productToStore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductToStoreDto {
    private Long id;
    private Long storeId;
    private Long productId;
}
