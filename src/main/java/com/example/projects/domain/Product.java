package com.example.projects.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String color;
    private Integer quantity;
    private Date created_date;
    private Date modified_date;
    private String buy_by;
    private Date buy_date;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    Category category;

}
