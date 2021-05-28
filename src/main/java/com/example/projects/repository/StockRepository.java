package com.example.projects.repository;

import com.example.projects.domain.Stock;
import com.example.projects.repository.custom.StockRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock , Integer> , StockRepositoryCustom {
}
