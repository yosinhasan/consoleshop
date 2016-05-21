package com.epam.pp.hasan.strategy;

import com.epam.pp.hasan.entity.Product;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public interface ProductStrategy {
	/**
	 * Add product.
	 * 
	 * @return Product
	 */
	Product addProduct(Class productClass);
}
