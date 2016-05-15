
package com.epam.pp.hasan.repository.product;

import java.util.HashMap;

import com.epam.pp.hasan.entities.Product;

/**
 * Interface For the Product DAO
 * 
 * @author Yosin_Hasan
 * 
 */
public interface ProductRepository {
	/**
	 * Find product by id.
	 * 
	 * @param id
	 *            product id
	 * @return Product
	 */
	public Product findProduct(Integer id);

	/**
	 * Find product by field and value.
	 * 
	 * @param field
	 *            product field
	 * @param value
	 *            product value
	 * @return Product
	 */
	public Product findProduct(String field, Object value);

	/**
	 * Add product to product list.
	 * 
	 * @param product
	 *            product to add
	 * @return Boolean
	 */
	public Boolean addProduct(Product product);

	/**
	 * Remove product from product list by id.
	 * 
	 * @param id
	 *            product id
	 * @return Boolean
	 */
	public Boolean removeProduct(Integer id);

	/**
	 * Remove product from product list by field and value.
	 * 
	 * @param field
	 *            field
	 * @param value
	 *            value
	 * @return Boolean
	 */
	public Boolean removeProduct(String field, Object value);

	/**
	 * Update product.
	 * 
	 * @param product
	 *            product
	 * @return Boolean
	 */
	public Boolean updateProduct(Product product);

	/**
	 * Get all products from product list.
	 * 
	 * @return HashMap<Integer, Product>
	 */
	public HashMap<Integer, Product> findAll();
}
