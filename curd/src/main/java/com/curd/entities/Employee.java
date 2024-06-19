package com.curd.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE )
    private int id;
    private String name;
    private String city;

}
