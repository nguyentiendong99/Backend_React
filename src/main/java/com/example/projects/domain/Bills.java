package com.example.projects.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bills")
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private int userID;
    private String phone;
    private String name ;
    private String address;
    private int quantity;
    @Column(name = "total_price")
    private double totalPrice;
    private String note;
}
