/**
 * 
 */
package com.epam.pp.hasan.views;

import com.epam.pp.hasan.utils.Request;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewNotFound implements View {

	@Override
	public void view(Request request) {
		System.out.println("ERROR 404");

	}

}
