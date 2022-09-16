package com.example.demo.deliveryMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class DeliveryMethodDto {
    private Long deliveryId;
    private String name;
}
