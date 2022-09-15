package com.example.demo.mapper;

import com.example.demo.entity.Orders;
import com.example.demo.orders.OrdersCreateDto;
import com.example.demo.orders.OrdersDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
    OrdersDto ordersToDto(Orders entity);
    Orders dtoToOrders(OrdersCreateDto dto);
}
