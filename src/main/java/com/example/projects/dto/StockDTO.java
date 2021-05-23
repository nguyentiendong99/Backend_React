package com.example.projects.dto;

import com.example.projects.domain.Agents;
import com.example.projects.domain.StockPlace;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class StockDTO {
    private Integer id;
    private String name;
    private String address;
    private Long capacity;
    private Long quantityInventory;
    private Date importDate;
    private Date exportDate;
    private String importBy;
    private String exportBy;
    private double totalPrice;
//    List<Agents> agents;
//    StockPlace stockPlace;

}
