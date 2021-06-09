package com.example.projects.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    Product product;
    private int quantity;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "order_date")
    private Date orderDated;
    @Column(name = "user_id")
    private int userID;
    @Column(name = "bill_id")
    private int billID;
    private String address;
    @Column(name = "payment_type")
    private String paymentType;
    @Column(name = "delivery_type")
    private String deliveryType;
}
