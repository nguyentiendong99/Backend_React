package com.example.projects.dto;

import com.example.projects.domain.StockPlace;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CompanyDTO {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String manager;
    private Date createdDate;
    List<StockPlace> places;
}
