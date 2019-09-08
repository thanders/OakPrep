package com.oakprep.backend.services;

import java.util.List;

import com.oakprep.backend.persistence.Order;

public interface OrderService {

    List<Order> getAllOrdersForCustomer(String customerId);

    Order getOrderByIdForCustomer(String customerId, String orderId);

}