package com.example.projects.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
//    List<StockPlace> places;
}
