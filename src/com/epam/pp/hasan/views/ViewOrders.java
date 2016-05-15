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
public class ViewOrders implements View {

	@Override
	public void view(Request request) {
		Map<Long, Order> orders = (Map<Long, Order>) request.get("orders");
		request.remove("orders");
		System.out.println("=================================ORDERS===============================");
		generateViewOrders(orders);
		System.out.println("=================================ORDERS===============================");
	}

	private void generateViewOrders(final Map<Long, Order> items) {
		if (items == null || items.size() <= 0) {
			System.out.println("ORDER LIST IS EMPTY");
			return;
		}
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
