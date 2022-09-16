package com.example.demo.stores;

import lombok.Data;

@Data
public class StoresCreateDto {
    private String name;
    private String ownerFio;
    private String location;
    private String address;
}
