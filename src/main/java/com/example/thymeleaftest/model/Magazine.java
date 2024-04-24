package com.example.thymeleaftest.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "magazines")
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private String magazinePhoto;

    @ManyToMany(mappedBy = "magazines")
    List<Owner> owners = new ArrayList<>();


}
