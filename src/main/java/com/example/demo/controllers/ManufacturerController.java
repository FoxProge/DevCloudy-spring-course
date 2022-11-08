package com.example.demo.controllers;

import com.example.demo.manufacturer.ManufacturerCreateDto;
import com.example.demo.manufacturer.ManufacturerDto;
import com.example.demo.service.ManufacturerService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
@Getter
@Setter
public class ManufacturerController {

    private final ManufacturerService service;
    @GetMapping(value = "/manufacturer")
    public List<ManufacturerDto> getManufacturers(){
        return service.getManufacturers();
    }

    @GetMapping(
            value = "/manufacturer/{manufacturerId}",
            produces = {"application/json"})
    public ResponseEntity<ManufacturerDto> getManufacturer(
            @Parameter(description = "Идентификатор изготовителя", required = true)
            @PositiveOrZero @PathVariable("manufacturerId") Long manufacturerId){
        return ResponseEntity.ok(service.getManufacturerById(manufacturerId));
    }

    @DeleteMapping(value = "/manufacturer/delete/{manufacturerId}")
    public ResponseEntity<Void> deleteManufacturer(
            @Parameter(description = "Идентификатор изготовителя", required = true)
            @PositiveOrZero @PathVariable("manufacturerId") Long manufacturerId){
        service.deleteManufacturer(manufacturerId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/manufacturer/create")
    public ResponseEntity<ManufacturerDto> createManufacturer(
            @Parameter(description = "Запрос на создание изготовителя")
            @Valid @RequestBody ManufacturerCreateDto request){
        return new ResponseEntity<>(service.createManufacturer(request), HttpStatus.CREATED);
    }
}
