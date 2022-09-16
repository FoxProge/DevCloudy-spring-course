package com.example.demo.mapper;

import com.example.demo.deliveryMethod.DeliveryMethodCreateDto;
import com.example.demo.deliveryMethod.DeliveryMethodDto;
import com.example.demo.entity.DeliveryMethod;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryMethodMapper {
    DeliveryMethodDto deliveryMethodToDto(DeliveryMethod entity);
    DeliveryMethod dtoToDeliveryMethod(DeliveryMethodCreateDto dto);
}
