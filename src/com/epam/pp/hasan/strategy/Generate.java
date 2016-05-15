package com.epam.pp.hasan.strategy;

import com.epam.pp.hasan.entities.Product;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public class Generate implements ProductStrategy {

	@Override
	public Product addProduct() {
		Product newProd = new Product();
		long code = (long) (Math.random() * 1000000);
		String name = "Product name " + code;
		String description = "Product description " + code;
		int price = (int) (Math.random() * 10000);
		newProd.setName(name);
		newProd.setDescription(description);
		newProd.setPrice(price);
		return newProd;
	}

}
