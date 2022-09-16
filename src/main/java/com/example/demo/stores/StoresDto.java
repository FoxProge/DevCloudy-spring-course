package com.example.demo.stores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class StoresDto {
    private Long storeId;
    private String name;
    private String ownerFio;
    private String location;
    private String address;
}
