package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StockStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stockStatusId;
    private String name;
}
