package com.example.demo.orders;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrdersCreateDto {
    private String username;
    private String address;
    private float price;
    private LocalDate deliveryDate;
}
