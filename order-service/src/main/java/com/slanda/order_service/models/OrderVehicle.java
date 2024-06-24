package com.slanda.order_service.models;

import com.slanda.vehicle_commons.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OrderVehicle implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private int quantity;

    @ManyToOne
    private Order order;
    @ManyToOne
    private Vehicle vehicle;
}
