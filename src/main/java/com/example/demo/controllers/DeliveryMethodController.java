package com.example.demo.controllers;

import com.example.demo.deliveryMethod.DeliveryMethodCreateDto;
import com.example.demo.deliveryMethod.DeliveryMethodDto;
import com.example.demo.service.DeliveryMethodService;
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
public class DeliveryMethodController {
    private final DeliveryMethodService service;
    @GetMapping(value = "/delivery-method")
    public List<DeliveryMethodDto> getDeliveryMethods(){
        return service.getDeliveryMethods();
    }

    @GetMapping(
            value = "/delivery-method/{deliveryMethodId}",
            produces = {"application/json"})
    public ResponseEntity<DeliveryMethodDto> getDeliveryMethod(
            @Parameter(description = "Идентификатор вида доставки", required = true)
            @PositiveOrZero @PathVariable("deliveryMethodId") Long deliveryMethodId){
        return ResponseEntity.ok(service.getDeliveryMethodById(deliveryMethodId));
    }

    @DeleteMapping(value = "/delivery-method/{deliveryMethodId}")
    public ResponseEntity<Void> deleteDeliveryMethod(
            @Parameter(description = "Идентификатор вида доставки", required = true)
            @PositiveOrZero @PathVariable("deliveryMethodId") Long deliveryMethodId){
        service.deleteDeliveryMethod(deliveryMethodId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/delivery-method/{deliveryMethodId}")
    public ResponseEntity<DeliveryMethodDto> createDeliveryMethod(
            @Parameter(description = "Запрос на создание вида доставки")
            @Valid @RequestBody DeliveryMethodCreateDto request){
        return new ResponseEntity<>(service.createDeliveryMethod(request), HttpStatus.CREATED);
    }
}
