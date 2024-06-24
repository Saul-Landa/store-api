package com.slanda.user_commons.models;

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
public class SalesPerson implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50)
    private String employeeNumber;

    @ManyToOne
    private Person person;
}
