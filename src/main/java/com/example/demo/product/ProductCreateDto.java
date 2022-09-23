package com.example.demo.product;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Manufacturer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductCreateDto {
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
    private String image;
    private int categoryId;
    private int manufacturerId;
    private int storeId;
    private int orderId;
}
