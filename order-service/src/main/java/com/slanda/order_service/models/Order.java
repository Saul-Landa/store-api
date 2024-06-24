package com.slanda.order_service.models;

import com.slanda.user_commons.models.SalesPerson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orden")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Date dateCreated;
    @Column(length = 50)
    private String ipAddress;
    private String clientFirstName;
    private String clientLastName;

    @ManyToOne
    private OrderStatus orderStatus;
    @ManyToOne
    private SalesPerson salesPerson;
}
