package com.example.demo.productToCart;

import lombok.Data;

@Data
public class ProductToCartCreateDto {
    private Long productId;
    private Long orderId;
}
