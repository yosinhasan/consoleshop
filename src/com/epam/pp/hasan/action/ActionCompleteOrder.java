package com.epam.pp.hasan.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.entity.Order;
import com.epam.pp.hasan.entity.OrderStatus;
import com.epam.pp.hasan.entity.Product;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.Request;

public class ActionCompleteOrder extends Action {
	public ActionCompleteOrder(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		HashMap<Integer, Integer> basket = productFacade.getBasketProducts();
		String status = "ORDER NOT COMPLETED";
		if (basket != null && basket.size() > 0) {
			Order order = new Order();
			Iterator<Entry<Integer, Integer>> map = basket.entrySet().iterator();
			Map<Integer, Product> items = productFacade.findAll();
			Product item = null;
			Integer amount = null;
			Integer summ = 0;
			Entry<Integer, Integer> entry = null;
			while (map.hasNext()) {
				entry = map.next();
				item = items.get(entry.getKey());
				amount = entry.getValue();
				item.setQuantity(amount);
				order.addProduct(item);
				summ += amount * item.getPrice();
			}
			order.setTotalPrice(summ);
			order.setStatus(OrderStatus.COMPLETED);
			productFacade.addOrder(order);
			productFacade.clearBasket();
			status = "ORDER COMPLETED";
		}
		request.set("orderStatus", status);
		return Fields.ACTION_COMPLETE_ORDER;
	}

}
