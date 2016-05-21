/**
 * 
 */
package com.epam.pp.hasan.view;

import com.epam.pp.hasan.util.Request;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewCompleteOrder implements View {

	@Override
	public void view(Request request) {
		System.out.println(request.get("orderStatus"));
		request.remove("orderStatus");

	}
}
