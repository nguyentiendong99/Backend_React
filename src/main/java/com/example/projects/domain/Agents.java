package com.example.projects.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "agents")
public class Agents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String owner;
    @Column(name = "purchase_date")
    private Date purchaseDate;
    @Column(name = "total_price")
    private Double totalPrice;
    private Long quantity;

    @OneToMany(mappedBy = "agents")
    List<Brand> brands;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    Stock stock;
}
