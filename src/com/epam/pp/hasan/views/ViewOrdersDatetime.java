/**
 * 
 */
package com.epam.pp.hasan.views;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.pp.hasan.entities.Order;
import com.epam.pp.hasan.entities.Product;
import com.epam.pp.hasan.utils.Date;
import com.epam.pp.hasan.utils.Request;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewOrdersDatetime implements View {

	@Override
	public void view(Request request) {
		String date = (String) request.get("date");
		Map<Long, Order> items = (Map<Long, Order>) request.get("orders");
		request.remove("date");
		request.remove("orders");
		System.out.println("=================================ORDERS===============================");
		System.out.println("DATE: " + date);
		if (items != null) {
			Iterator<Entry<Long, Order>> iter = items.entrySet().iterator();
			Order order = null;
			Entry<Long, Order> entry = null;
			while (iter.hasNext()) {
				entry = iter.next();
				order = entry.getValue();
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Order datetime: " + Date.getTimestamp(entry.getKey()));
				System.out.println("Order status: " + order.getStatus());
				System.out.println("Order cost: " + order.getTotalPrice() + "$");
				System.out.println("----------------------------------------------------------------------");
				Iterator<Product> iter2 = order.getItems().iterator();
				while (iter2.hasNext()) {
					System.out.println(generateProductForOrder(iter2.next()));
				}
				System.out.println("----------------------------------------------------------------------");
			}

		} else {
			System.out.println("NO ORDERS WERE FOUND FOR INPUTED DATE");
		}

		System.out.println("=================================ORDERS===============================");

	}

	private String generateProductForOrder(final Product item) {
		StringBuilder str = new StringBuilder();
		str.append("name: " + item.getName() + " ");
		str.append("code: " + item.getId() + " ");
		str.append("price: " + item.getPrice() + " ");
		str.append("total price for " + item.getQuantity() + " pieces: " + (item.getQuantity() * item.getPrice()));
		return str.toString();
	}
}
