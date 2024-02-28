package com.car_rental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    private String name;

    private String color;

    private String transmission;

    private String brand;

    private String type;

    private Date modelYear;

    private String description;

    private Integer price;

    @Column(columnDefinition = "longblob")
    private byte [] image;

}
