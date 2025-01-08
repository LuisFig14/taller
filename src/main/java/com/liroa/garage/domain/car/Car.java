package com.liroa.garage.domain.car;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.liroa.garage.domain.client.Client;
import com.liroa.garage.domain.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Car")
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idCar")
public class Car {

    @Id
    @Column(name = "id_car")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCar;
    private String brand;
    private String model;
    private String comments;


    @ManyToOne
    @JoinColumn(name = "id_client")
    @JsonBackReference
    Client client;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();

}
