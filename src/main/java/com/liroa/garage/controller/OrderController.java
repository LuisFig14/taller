package com.liroa.garage.controller;

import com.liroa.garage.domain.client.DataUpdateClient;
import com.liroa.garage.domain.order.DataCreateOrder;
import com.liroa.garage.domain.order.DataListOrder;
import com.liroa.garage.domain.order.DataUpdateOrder;
import com.liroa.garage.domain.order.Order;
import com.liroa.garage.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/{idClient}/{idCar}")
    public ResponseEntity<Order> createOrder(@PathVariable Long idClient, @PathVariable Long idCar, @RequestBody DataCreateOrder dataCreateOrder){

        orderService.createOrder(idClient, idCar, dataCreateOrder);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<DataListOrder>> getAllOrders (){

        return ResponseEntity.ok(orderService.getAllOrders());

    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long idOrder){

        return ResponseEntity.ok(orderService.getOrderById(idOrder));

    }

    @PutMapping("/{idOrder}")
    public ResponseEntity<?> updateOrder(@PathVariable Long idOrder, @RequestBody DataUpdateOrder dataUpdateOrder){

        Order order = orderService.updateOrder(idOrder,dataUpdateOrder);

        return ResponseEntity.ok(new DataUpdateOrder(order.getName(), order.getDescription()));

    }

    @DeleteMapping("/{idOrder}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long idOrder){

        orderService.deleteOrder(idOrder);

        return ResponseEntity.noContent().build();

    }



}
