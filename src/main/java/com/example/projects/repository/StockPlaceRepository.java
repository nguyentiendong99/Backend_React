package com.example.projects.repository;

import com.example.projects.domain.StockPlace;
import com.example.projects.repository.custom.StockRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPlaceRepository extends JpaRepository<StockPlace , Integer> , StockRepositoryCustom {
}
