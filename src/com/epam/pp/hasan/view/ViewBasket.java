/**
 *
 */
package com.epam.pp.hasan.view;

import java.util.Iterator;
import java.util.Map;

import com.epam.pp.hasan.entity.Product;
import com.epam.pp.hasan.util.Request;

/**
 * @author Yosin_Hasan
 */
public class ViewBasket implements View {

	@Override
	public void view(Request request) {
		Map<Integer, Integer> basket = (Map<Integer, Integer>) request.get("basket");
		Map<Integer, Product> items = (Map<Integer, Product>) request.get("products");
		request.remove("basket");
		request.remove("products");
		System.out.println("=================================BASKET===============================");
		Iterator<Map.Entry<Integer, Integer>> map = basket.entrySet().iterator();
		int k = 0;
		Product item = null;
		Integer amount = null;
		Integer summ = 0;
		Map.Entry<Integer, Integer> entry = null;
		while (map.hasNext()) {
			entry = map.next();
			item = items.get(entry.getKey());
			amount = entry.getValue();
			System.out.print("$" + k++ + ": ");
			System.out.println(generateProductForBasket(item, amount));
			summ += amount * item.getPrice();
		}
		if (summ > 0) {
			System.out.println("Total sum: " + summ);
		} else {
			System.out.println("BASKET IS EMPTY");
		}
		System.out.println("=================================BASKET===============================");
	}

	/**
	 * Generate product for basket section.
	 *
	 * @param item
	 *            products
	 * @param amount
	 *            amount
	 * @return String
	 */
	private String generateProductForBasket(final Product item, final Integer amount) {
		StringBuilder str = new StringBuilder();
		str.append("name: " + item.getName() + " ");
		str.append("code: " + item.getId() + " ");
		str.append("price: " + item.getPrice() + " ");
		str.append("total price for " + amount + " pieces: " + (amount * item.getPrice()));
		return str.toString();
	}

}
