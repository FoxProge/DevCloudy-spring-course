package com.example.demo.manufacturer;

import lombok.Data;

@Data
public class ManufacturerCreateDto {
    private String manufacturerName;
    private String ownerFio;
    private String address;
    private String location;
}
