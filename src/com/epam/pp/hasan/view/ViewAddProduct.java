/**
 * 
 */
package com.epam.pp.hasan.view;

import com.epam.pp.hasan.util.Request;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewAddProduct implements View {

	@Override
	public void view(Request request) {
		Boolean isAdded = (Boolean) request.get("isAdded");
		request.remove("isAdded");
		if (isAdded) {
			System.out.println("PRODUCT WAS ADDED");
		} else {
			System.out.println("PRODUCT WAS NOT ADDED");
		}

	}
}
