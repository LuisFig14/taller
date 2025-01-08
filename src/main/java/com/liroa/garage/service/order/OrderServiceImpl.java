package com.liroa.garage.service.order;

import com.liroa.garage.domain.car.Car;
import com.liroa.garage.domain.client.Client;
import com.liroa.garage.domain.order.DataCreateOrder;
import com.liroa.garage.domain.order.DataListOrder;
import com.liroa.garage.domain.order.DataUpdateOrder;
import com.liroa.garage.domain.order.Order;
import com.liroa.garage.repository.CarRepository;
import com.liroa.garage.repository.ClientRepository;
import com.liroa.garage.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public void createOrder (Long idClient, Long idCar, DataCreateOrder dataCreateOrder) {

        Client client = clientRepository.findById(idClient)
                .orElseThrow(()-> new RuntimeException("Id client not found"));

        Car car = carRepository.findById(idCar)
                .orElseThrow(()-> new RuntimeException("Id car not found"));

        if(!car.getClient().getIdClient().equals(client.getIdClient())){
            throw new RuntimeException("The car does not belong to the client");
        }

        Order order = new Order();
        order.setName(dataCreateOrder.name());
        order.setDescription(dataCreateOrder.description());
        order.setClient(client);
        order.setCar(car);

        orderRepository.save(order);
    }

    @Override
    public List<DataListOrder> getAllOrders() {

        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(
                order -> new DataListOrder(
                        order.getName(),
                        order.getDescription()
                )).toList();

    }

    @Override
    public Order getOrderById(Long idOrder) {

        return orderRepository.findById(idOrder).orElseThrow(()-> new RuntimeException("Id not found"));

    }

    @Override
    @Transactional
    public Order updateOrder(Long idOrder, DataUpdateOrder dataUpdateOrder) {

        Order order = orderRepository.findById(idOrder)
                .orElseThrow(()-> new RuntimeException("Id not found"));

        order.setName(dataUpdateOrder.name());
        order.setDescription(dataUpdateOrder.description());

        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long idOrder) {

        Order order = orderRepository.findById(idOrder)
                .orElseThrow(()-> new RuntimeException("Id not found"));

        orderRepository.delete(order);

    }
}
