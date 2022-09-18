package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DeliveryMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryId;
    private String name;
}
