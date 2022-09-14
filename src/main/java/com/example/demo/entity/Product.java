package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
}
