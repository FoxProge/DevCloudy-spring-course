package com.example.demo.productImage;

import lombok.Data;

@Data
public class ProductImageCreateDto {
    private String imagePath;
    private Long productId;
}
