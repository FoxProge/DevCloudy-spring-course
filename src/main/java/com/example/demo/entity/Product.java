package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String product;
    private String location;
    private int quantity;
    private String stockStatus;
    private float price;
    private float width;
    private float length;
    private float weight;
    private float height;
    private LocalDate date_added;
    private int viewed;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Stores store;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
}
