package com.epam.pp.hasan.strategy;

import com.epam.pp.hasan.entities.Product;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public class AddProduct {
	private final ProductStrategy strategy;

	/**
	 * Constructor with strategy argument.
	 * 
	 * @param strategy
	 *            strategy
	 */
	public AddProduct(final ProductStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Generate product.
	 * 
	 * @return Product
	 */
	public final Product getGeneratedProduct() {
		return strategy.addProduct();
	}
}
