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
public class Stores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeId;
    private String name;
    private String ownerFio;
    private String location;
    private String address;
}
