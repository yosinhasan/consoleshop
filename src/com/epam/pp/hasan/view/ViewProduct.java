/**
 * 
 */
package com.epam.pp.hasan.view;

import com.epam.pp.hasan.entity.Product;
import com.epam.pp.hasan.util.Request;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewProduct implements View {

	@Override
	public void view(Request request) {
		Product item = (Product) request.get("product");
		request.remove("product");
		System.out.println("=================================PRODUCTS===============================");

		System.out.println("------------------------------------------------------------------------");
		if (item != null) {
			System.out.println("Name: " + item.getName() + "\nCode: " + item.getId() + "\nPrice " + item.getPrice()
					+ "\nDescription " + item.getDescription());
		} else {
			System.out.println("PRODUCT NOT FOUND");
		}
		System.out.println("------------------------------------------------------------------------");
		System.out.println("=================================PRODUCTS===============================");

	}
}
