package com.example.projects.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "brands")
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "agent_id")
    private Integer agentId;
    private String name;
    private String description;

//    @OneToMany(mappedBy = "brand")
//    List<Category> categories;
//
//    @ManyToOne
//    @JoinColumn(name = "agent_id")
//    Agents agents;
}
