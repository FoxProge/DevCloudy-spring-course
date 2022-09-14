package com.example.demo.productToCategory;

import lombok.Data;

@Data
public class ProductToCategoryCreateDto {
    private Long productId;
    private Long categoryId;
}
