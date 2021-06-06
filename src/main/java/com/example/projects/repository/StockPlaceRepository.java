package com.example.projects.repository;

import com.example.projects.domain.StockPlace;
import com.example.projects.repository.custom.StockPlaceRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockPlaceRepository extends JpaRepository<StockPlace , Integer> , StockPlaceRepositoryCustom {
    Page<StockPlace> findAll(Pageable pageable);
    Page<StockPlace> findByCompanyId(Integer id , Pageable pageable);
}
