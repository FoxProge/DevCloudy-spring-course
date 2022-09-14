package com.example.demo.repository;

import com.example.demo.entity.ProductToCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductToCategoryRepository extends JpaRepository<ProductToCategory, Long> {
}
