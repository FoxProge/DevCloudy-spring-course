package com.example.demo.productToCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductToCategoryDto {
    private Long id;
    private Long productId;
    private Long categoryId;
}
