package com.liroa.garage.domain.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.liroa.garage.domain.car.Car;
import com.liroa.garage.domain.client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Order")
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idOrder")
public class Order {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_client")
    @JsonBackReference
    Client client;

    @ManyToOne
    @JoinColumn(name = "id_car")
    @JsonBackReference
    Car car;


}
