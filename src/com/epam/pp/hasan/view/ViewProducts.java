/**
 * 
 */
package com.epam.pp.hasan.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.pp.hasan.entity.Product;
import com.epam.pp.hasan.util.Request;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewProducts implements View {

	@Override
	public void view(Request request) {
		Map<Integer, Product> map = (Map<Integer, Product>) request.get("products");
		request.remove("products");
		System.out.println("=================================PRODUCTS===============================");

		Iterator<Entry<Integer, Product>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			generateProductView(iter.next().getValue());
		}
		System.out.println("=================================PRODUCTS===============================");

	}

	private void generateProductView(final Product item) {
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Name: " + item.getName() + "\nCode: " + item.getId() + "\nPrice " + item.getPrice()
				+ "\nDescription " + item.getDescription());

		System.out.println("------------------------------------------------------------------------");
	}

}
