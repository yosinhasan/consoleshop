package com.epam.pp.hasan.repository.order;

import java.util.SortedMap;
import java.util.TreeMap;

import com.epam.pp.hasan.entities.Order;
import com.epam.pp.hasan.utils.Date;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public class OrderRepositoryImpl implements OrderRepository {
	private TreeMap<Long, Order> orders;

	/**
	 * 
	 */
	public OrderRepositoryImpl() {
		orders = new TreeMap<Long, Order>();
	}

	@Override
	public SortedMap<Long, Order> findOrders(Long startDate, Long endDate) {
		if (endDate < startDate) {
			return null;
		}
		return orders.subMap(startDate, endDate);
	}

	@Override
	public SortedMap<Long, Order> findOrders(String date) {
		Long startdate = null;
		Long enddate = null;
		try {
			startdate = Date.getMilliSeconds(date + " 00:00:00");
			enddate = Date.getMilliSeconds(date + " 23:59:59");
		} catch (IllegalArgumentException e) {
			return null;
		}
		return orders.subMap(startdate, enddate);
	}

	@Override
	public Boolean addOrder(Order order) {
		if (order != null) {
			orders.put(Date.getCurrentTime(), order);
			return true;
		}
		return false;
	}

	@Override
	public Boolean removeOrder(Order order) {
		throw new UnsupportedOperationException();
	}

	@Override
	public TreeMap<Long, Order> findAll() {
		return orders;
	}

}
