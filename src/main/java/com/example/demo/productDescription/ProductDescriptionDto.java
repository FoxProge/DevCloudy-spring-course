package com.example.demo.productDescription;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDescriptionDto {
    private Long id;
    private Long productId;
    private String description;
}
