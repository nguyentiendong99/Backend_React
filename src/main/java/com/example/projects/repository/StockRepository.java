package com.example.projects.repository;

import com.example.projects.domain.Stock;
import com.example.projects.repository.custom.StockRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock , Integer> , StockRepositoryCustom {
    Page<Stock> findAll(Pageable pageable);
    Page<Stock> findByStockPlaceId(Integer id , Pageable pageable);
}
