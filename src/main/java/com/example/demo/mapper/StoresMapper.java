package com.example.demo.mapper;

import com.example.demo.stores.StoresCreateDto;
import com.example.demo.stores.StoresDto;
import com.example.demo.entity.Stores;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoresMapper {
    StoresDto storesToDto(Stores entity);
    Stores dtoToStores(StoresCreateDto dto);
}
