package com.example.projects.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "stock")
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "stock_place_id")
    private Integer stockPlaceId;
    private String name;
    private String address;
    private Long capacity;
    @Column(name = "quantity_inventory")
    private Long quantityInventory;
    @Column(name = "import_date")
    private Date importDate;
    @Column(name = "export_date")
    private Date exportDate;
    @Column(name = "import_by")
    private String importBy;
    @Column(name = "export_by")
    private String exportBy;
    @Column(name = "total_price")
    private double totalPrice;
//    @OneToMany(mappedBy = "stock")
//    List<Agents> agents;
//
//    @ManyToOne
//    @JoinColumn(name = "stock_place_id")
//    StockPlace stockPlace;
}
