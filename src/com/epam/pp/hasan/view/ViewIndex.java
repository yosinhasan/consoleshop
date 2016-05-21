/**
 * 
 */
package com.epam.pp.hasan.view;

import com.epam.pp.hasan.util.Request;

/**
 * @author Yosin_Hasan
 *
 */
public class ViewIndex implements View {

	@Override
	public void view(Request request) {
		System.out.println("===========================YOSIN STORE===========================");
		System.out.println("=============================WELCOME=============================");
		Integer k = 0;
		System.out.println(generateMenu(k++, "Home"));
		System.out.println(generateMenu(k++, "SHOW PRODUCTS"));
		System.out.println(generateMenu(k++, "SHOW PRODUCT"));
		System.out.println(generateMenu(k++, "SHOW LAST 5 PRODUCTS"));
		System.out.println(generateMenu(k++, "SHOW BASKET"));
		System.out.println(generateMenu(k++, "SHOW ORDERS"));
		System.out.println(generateMenu(k++, "SHOW ORDERS BY DATE"));
		System.out.println(generateMenu(k++, "SHOW ORDERS BY SPECIFIC DATETIME"));
		System.out.println(generateMenu(k++, "ADD PRODUCT TO BASKET"));
		System.out.println(generateMenu(k++, "COMPLETE ORDER"));
		System.out.println(generateMenu(k++, "ADD PRODUCT"));
		System.out.println(generateMenu(k, "Exit"));

	}

	private String generateMenu(final Integer num, final String value) {
		return "=>" + num + " " + value;
	}

}
