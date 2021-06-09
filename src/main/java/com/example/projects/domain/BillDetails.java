package com.example.projects.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bill_details")
public class BillDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    Product product;
    private int quantity;
    private double price;
    @Column(name = "user_id")
    private int userID;
}
