package com.slanda.vehicle_commons.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50)
    private String hawa;
    private String color;
    private int stock;
    private float price;
    private float discount;
    private String description;
    @Column(length = 50)
    private String model;
    private boolean active;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private VehicleType vehicleType;
}
