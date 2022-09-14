package com.example.demo.product;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductCreateDto {
    private String productName;
    private String location;
    private int quantity;
    private Long stockStatusId;
    private Long manufacturerId;
    private float price;
    private float width;
    private float length;
    private float weight;
    private float height;
    private LocalDate date_added;
    private int viewed;
}
