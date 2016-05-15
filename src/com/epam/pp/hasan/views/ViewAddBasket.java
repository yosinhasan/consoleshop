/**
 * 
 */
package com.epam.pp.hasan.views;

import com.epam.pp.hasan.utils.Request;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewAddBasket implements View {

	@Override
	public void view(Request request) {
		Boolean isAdded = (Boolean) request.get("isAdded");
		if (isAdded) {
			System.out.println("PRODUCT ADDED TO BASKET");
		} else {
			System.out.println("PRODUCT NOT ADDED TO BASKET");
		}
	}
}
