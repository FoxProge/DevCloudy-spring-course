package com.example.demo.product;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDto {
    private Long productId;
    private String product;
    private String location;
    private int quantity;
    private String stockStatus;
    private float price;
    private float width;
    private float length;
    private float weight;
    private float height;
    private LocalDate date_added;
    private int viewed;
    private Long categoryId;
    private Long manufacturerId;
    private Long storeId;
    private Long orderId;
}
