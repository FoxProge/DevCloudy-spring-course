package com.example.demo.productToCart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductToCartDto {
    private Long id;
    private Long productId;
    private Long orderId;
}
