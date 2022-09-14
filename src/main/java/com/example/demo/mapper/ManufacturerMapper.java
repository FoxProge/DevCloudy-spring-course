package com.example.demo.mapper;

import com.example.demo.entity.Manufacturer;
import com.example.demo.manufacturer.ManufacturerCreateDto;
import com.example.demo.manufacturer.ManufacturerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    ManufacturerDto manufacturerToDto(Manufacturer entity);
    Manufacturer dtoToManufacturer(ManufacturerCreateDto dto);

}
