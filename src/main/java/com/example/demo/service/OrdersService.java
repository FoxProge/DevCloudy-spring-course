package com.example.demo.service;

import com.example.demo.orders.OrdersCreateDto;
import com.example.demo.orders.OrdersDto;
import com.example.demo.entity.Orders;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrdersService {
    private final OrdersRepository repository;
    private final OrdersMapper mapper;
    public OrdersService(OrdersRepository repository, OrdersMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<OrdersDto> getOrders(){
        log.info("Получение всех заказов");
        return repository.findAll()
                .stream()
                .map(mapper::ordersToDto).collect(Collectors.toList());
    }
    public OrdersDto getOrdersById(Long id){
        log.info("Получение заказа по Id");
        return mapper.ordersToDto(repository.findById(id).orElse(null));
    }
    public void deleteOrders(Long id){
        log.info("Удаление заказа");
        repository.deleteById(id);
    }
    public OrdersDto createOrders(OrdersCreateDto request){
        log.info("Создание заказа");
        Orders orders = mapper.dtoToOrders(request);
        repository.save(orders);
        return mapper.ordersToDto(orders);
    }
}
