package com.example.demo.controllers;

import com.example.demo.orders.OrdersCreateDto;
import com.example.demo.orders.OrdersDto;
import com.example.demo.service.OrdersService;
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
public class OrdersController {
    private final OrdersService service;
    @GetMapping(value = "/orders")
    public List<OrdersDto> getOrders(){
        return service.getOrders();
    }

    @GetMapping(
            value = "/orders/{ordersId}",
            produces = {"application/json"})
    public ResponseEntity<OrdersDto> getOrders(
            @Parameter(description = "Идентификатор заказа", required = true)
            @PositiveOrZero @PathVariable("ordersId") Long ordersId){
        return ResponseEntity.ok(service.getOrdersById(ordersId));
    }

    @DeleteMapping(value = "/orders/{ordersId}")
    public ResponseEntity<Void> deleteOrders(
            @Parameter(description = "Идентификатор заказа", required = true)
            @PositiveOrZero @PathVariable("ordersId") Long ordersId){
        service.deleteOrders(ordersId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "/orders/{ordersId}")
    public ResponseEntity<OrdersDto> createOrders(
            @Parameter(description = "Запрос на создание заказа")
            @Valid @RequestBody OrdersCreateDto request){
        return new ResponseEntity<>(service.createOrders(request), HttpStatus.CREATED);
    }
}
