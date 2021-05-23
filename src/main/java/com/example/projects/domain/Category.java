package com.example.projects.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Long quantity;
    private String description;

    @OneToMany(mappedBy = "category")
    List<Product> products;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brand brand;
}
