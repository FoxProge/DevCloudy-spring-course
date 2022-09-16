package com.example.demo.controllers;

import com.example.demo.service.StockStatusService;
import com.example.demo.stockStatus.StockStatusCreateDto;
import com.example.demo.stockStatus.StockStatusDto;
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
@AllArgsConstructor
@Getter
@Setter
public class StockStatusController {
    private final StockStatusService service;
    @GetMapping(value = "/stock-status")
    public List<StockStatusDto> getStockStatuses(){
        return service.getStockStatuses();
    }

    @GetMapping(
            value = "/stock-status/{stockStatusId}",
            produces = {"application/json"})
    public ResponseEntity<StockStatusDto> getStockStatus(
            @Parameter(description = "Идентификатор состояния запасов", required = true)
            @PositiveOrZero @PathVariable("stockStatusId") Long stockStatusId){
        return ResponseEntity.ok(service.getStockStatusById(stockStatusId));
    }

    @DeleteMapping(value = "/stock-status/{stockStatusId}")
    public ResponseEntity<Void> deleteStockStatus(
            @Parameter(description = "Идентификатор состояния запасов", required = true)
            @PositiveOrZero @PathVariable("stockStatusId") Long stockStatusId){
        service.deleteStockStatus(stockStatusId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/stock-status/{stockStatusId}")
    public ResponseEntity<StockStatusDto> createStockStatus(
            @Parameter(description = "Запрос на состояния запасов")
            @Valid @RequestBody StockStatusCreateDto request){
        return new ResponseEntity<>(service.createStockStatus(request), HttpStatus.CREATED);
    }
}
