/**
 * 
 */
package com.epam.pp.hasan.views;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.pp.hasan.entities.Order;
import com.epam.pp.hasan.utils.Date;
import com.epam.pp.hasan.utils.Request;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewOrdersDate implements View {

	@Override
	public void view(Request request) {
		Map<Long, Order> items = (Map<Long, Order>) request.get("orders");
		Long startDate = (Long) request.get("startDate");
		Long endDate = (Long) request.get("endDate");
		request.remove("endDate");
		request.remove("startDate");
		request.remove("orders");
		System.out.println("=================================ORDERS===============================");
		System.out.println("DATE RANGE: " + Date.getTimestamp(startDate) + " - " + Date.getTimestamp(endDate));
		if (items != null) {
			generateViewOrders(items);
		} else {
			System.out.println("NO ORDERS WERE FOUND FOR INPUTED DATE RANGE");
		}
		System.out.println("=================================ORDERS===============================");

	}

	private void generateViewOrders(final Map<Long, Order> items) {
		Iterator<Entry<Long, Order>> iter = items.entrySet().iterator();
		Entry<Long, Order> entry = null;
		while (iter.hasNext()) {
			entry = iter.next();
			System.out.println("");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Order datetime: " + Date.getTimestamp(entry.getKey()));
			System.out.println("Order status: " + entry.getValue().getStatus());
			System.out.println("Order cost: " + entry.getValue().getTotalPrice() + "$");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("");
		}

	}
}
