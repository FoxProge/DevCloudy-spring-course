package com.example.demo.repository;

import com.example.demo.entity.StockStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockStatusRepository extends JpaRepository<StockStatus, Long> {
}
