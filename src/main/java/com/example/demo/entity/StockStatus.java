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
public class StockStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stockStatusId;
    private String name;
}
