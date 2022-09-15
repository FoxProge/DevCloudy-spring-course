package com.example.demo.productImage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductImageDto {
    private Long imageId;
    private Long productId;
    private String imagePath;
}
