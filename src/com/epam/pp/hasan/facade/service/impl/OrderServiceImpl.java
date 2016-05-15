package com.epam.pp.hasan.facade.service.impl;

import com.epam.pp.hasan.entities.Order;
import com.epam.pp.hasan.facade.repository.order.OrderRepository;
import com.epam.pp.hasan.facade.service.OrderService;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Yosin_Hasan on 5/12/2016.
 */
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRep;

    /**
     *
     * @param orderRep order repository
     */
    public OrderServiceImpl(OrderRepository orderRep) {
        this.orderRep = orderRep;
    }
    @Override
    public SortedMap<Long, Order> findOrders(Long startDate, Long endDate) {
        return orderRep.findOrders(startDate, endDate);
    }

    @Override
    public SortedMap<Long, Order> findOrders(String date) {
        return orderRep.findOrders(date);
    }

    @Override
    public Boolean addOrder(Order order) {
        return orderRep.addOrder(order);
    }

    @Override
    public Boolean removeOrder(Order order) {
        return orderRep.removeOrder(order);
    }

    @Override
    public TreeMap<Long, Order> findAll() {
        return orderRep.findAll();
    }

}
