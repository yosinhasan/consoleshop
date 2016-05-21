package com.epam.pp.hasan.facade.service;

import com.epam.pp.hasan.entity.Order;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Yosin_Hasan on 5/12/2016.
 */
public interface OrderService {
    /**
     * Find all orders within date range.
     *
     * @param startDate
     *            start date
     * @param endDate
     *            end date
     * @return SortedMap<Long, Order>
     */
    public SortedMap<Long, Order> findOrders(Long startDate, Long endDate);

    /**
     * Find all orders within specific date.
     *
     * @param date
     *            date
     * @return SortedMap<Long, Order>
     */
    public SortedMap<Long, Order> findOrders(String date);

    /**
     * Add order to order list.
     *
     * @param order
     *            order
     * @return Boolean
     */
    public Boolean addOrder(Order order);

    /**
     * Remove order from order list.
     *
     * @param order
     *            order
     * @return Boolean
     */
    public Boolean removeOrder(Order order);

    /**
     * Get all orders from order list.
     *
     * @return TreeMap<Long, Order>
     */
    public TreeMap<Long, Order> findAll();
}
