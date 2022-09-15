package com.example.demo.productImage;

import lombok.Data;

@Data
public class ProductImageCreateDto {
    private Long productId;
    private String imagePath;
}
