/**
 * 
 */
package com.epam.pp.hasan.view;

import com.epam.pp.hasan.util.Request;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewExit implements View {

	@Override
	public void view(Request request) {
		System.out.println("Exiting");
		System.exit(0);

	}
}
