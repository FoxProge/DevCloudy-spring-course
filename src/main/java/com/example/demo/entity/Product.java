package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private String location;
    private int quantity;
    private Long stockStatusId;
    private Long manufacturerId;
    private float price;
    private float width;
    private float length;
    private float weight;
    private float height;
    private LocalDate date_added;
    private int viewed;
    @ManyToOne
    @JoinColumn()
    private Categories category;
}
