package com.epam.pp.hasan.repository.product;

import java.util.HashMap;

import com.epam.pp.hasan.entities.Product;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public class ProductRepositoryImpl implements ProductRepository {
	private HashMap<Integer, Product> data;
	private Integer k;

	/**
	 * 
	 */
	public ProductRepositoryImpl() {
		data = new HashMap<Integer, Product>();
		k = 0;
	}

	@Override
	public Product findProduct(Integer id) {
		if (id != null && id >= 0) {
			return data.get(id);
		}
		return null;
	}

	@Override
	public Product findProduct(String field, Object value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Boolean addProduct(Product product) {
		if (product == null) {
			return false;
		}
		product.setId(k);
		data.put(k++, product);
		return true;

	}

	@Override
	public Boolean removeProduct(Integer id) {
		if (id == null || !data.containsKey(id)) {
			return false;
		}
		data.remove(id);
		return true;
	}

	@Override
	public Boolean removeProduct(String field, Object value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Boolean updateProduct(Product product) {
		throw new UnsupportedOperationException();
	}

	@Override
	public HashMap<Integer, Product> findAll() {
		return data;
	}

}
