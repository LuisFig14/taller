package com.liroa.garage.service.order;

import com.liroa.garage.domain.order.DataCreateOrder;
import com.liroa.garage.domain.order.DataListOrder;
import com.liroa.garage.domain.order.DataUpdateOrder;
import com.liroa.garage.domain.order.Order;

import java.util.List;

public interface OrderService {

    void createOrder (Long idClient, Long idCar, DataCreateOrder dataCreateOrder);

    List<DataListOrder> getAllOrders ();

    Order getOrderById (Long idOrder);

    Order updateOrder (Long idOrder , DataUpdateOrder dataUpdateOrder);

    void deleteOrder (Long idOrder);

}
