package com.example.demo.controllers;

import com.example.demo.stores.StoresCreateDto;
import com.example.demo.stores.StoresDto;
import com.example.demo.service.StoresService;
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
public class StoresController {
    private final StoresService service;
    @GetMapping(value = "/stores")
    public List<StoresDto> getStores(){
        return service.getStores();
    }

    @GetMapping(
            value = "/stores/{storesId}",
            produces = {"application/json"})
    public ResponseEntity<StoresDto> getStore(
            @Parameter(description = "Идентификатор магазина", required = true)
            @PositiveOrZero @PathVariable("storesId") Long storesId){
        return ResponseEntity.ok(service.getStoresById(storesId));
    }

    @DeleteMapping(value = "/stores/delete/{storesId}")
    public ResponseEntity<Void> deleteStores(
            @Parameter(description = "Идентификатор магазина", required = true)
            @PositiveOrZero @PathVariable("storesId") Long storesId){
        service.deleteStores(storesId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/stores/create")
    public ResponseEntity<StoresDto> createStores(
            @Parameter(description = "Запрос на создание магазина")
            @Valid @RequestBody StoresCreateDto request){
        return new ResponseEntity<>(service.createStores(request), HttpStatus.CREATED);
    }
}
