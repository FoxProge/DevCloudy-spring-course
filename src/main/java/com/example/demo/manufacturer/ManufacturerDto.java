package com.example.demo.manufacturer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ManufacturerDto {
    private Long manufacturerId;
    private String manufacturerName;
    private String ownerFio;
    private String address;
    private String location;
}
