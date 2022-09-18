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
public class Stores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeId;
    private String name;
    private String ownerFio;
    private String location;
    private String address;
    @OneToMany()
    private List<Product> products = new ArrayList<Product>();
}
