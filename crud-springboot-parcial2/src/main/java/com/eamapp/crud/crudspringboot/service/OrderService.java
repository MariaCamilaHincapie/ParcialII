package com.eamapp.crud.crudspringboot.service;

import java.util.List;

import com.eamapp.crud.crudspringboot.entity.Order;

public interface OrderService {
    public List<Order> allOrders();

    public Order saveOrder(Order order);

    public Order getOrderById(Long id);

    public Order updateOrder(Order order);

    public void deleteOrder(Long id);
}