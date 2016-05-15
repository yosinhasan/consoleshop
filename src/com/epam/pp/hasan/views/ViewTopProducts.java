/**
 * 
 */
package com.epam.pp.hasan.views;

import java.util.ArrayList;

import com.epam.pp.hasan.entities.Product;
import com.epam.pp.hasan.utils.Request;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewTopProducts implements View {

	@Override
	public void view(Request request) {
		ArrayList<Product> items = (ArrayList<Product>) request.get("top");
		request.remove("top");
		System.out.println("=================================TOP 5===============================");
		for (Product item : items) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("Name: " + item.getName() + " Price: " + item.getPrice());
			System.out.println("---------------------------------------------------------------------");
		}
		System.out.println("=================================TOP 5===============================");

	}
}
