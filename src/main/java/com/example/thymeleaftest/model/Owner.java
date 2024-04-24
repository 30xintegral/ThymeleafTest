package com.example.thymeleaftest.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contactInfo;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Magazine> magazines = new ArrayList<>();


}
