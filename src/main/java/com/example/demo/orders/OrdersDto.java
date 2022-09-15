package com.example.demo.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class OrdersDto {
    private Long orderId;
    private String username;
    private String address;
    private float price;
    private LocalDate deliveryDate;
    private Long deliveryId;
}
