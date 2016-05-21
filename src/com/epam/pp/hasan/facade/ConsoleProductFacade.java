
package com.epam.pp.hasan.facade;

import com.epam.pp.hasan.entity.Order;
import com.epam.pp.hasan.entity.Product;
import com.epam.pp.hasan.facade.service.BasketService;
import com.epam.pp.hasan.facade.service.OrderService;
import com.epam.pp.hasan.facade.service.ProductService;

import java.util.*;

/**
 * Console Service for store.
 *
 * @author Yosin_Hasan
 */
public class ConsoleProductFacade {

	private final ProductService productService;
	private final OrderService orderService;
	private final BasketService basketService;

	public ConsoleProductFacade(ProductService productService, OrderService orderService, BasketService basketService) {
		this.productService = productService;
		this.orderService = orderService;
		this.basketService = basketService;
	}

	public Product findProduct(Integer id) {
		return productService.findProduct(id);
	}

	public Product findProduct(String field, Object value) {
		return productService.findProduct(field, value);
	}

	public SortedMap<Long, Order> findOrders(Long startDate, Long endDate) {
		return orderService.findOrders(startDate, endDate);
	}

	public SortedMap<Long, Order> findOrders(String date) {
		return orderService.findOrders(date);
	}

	public Boolean addOrder(Order order) {
		return orderService.addOrder(order);
	}

	public Boolean removeOrder(Order order) {
		return orderService.removeOrder(order);
	}

	public TreeMap<Long, Order> findAllOrders() {
		return orderService.findAll();
	}

	public Boolean addProduct(Product product) {
		return productService.addProduct(product);
	}

	public Boolean removeProduct(Integer id) {
		return productService.removeProduct(id);
	}

	public Boolean removeProduct(String field, Object value) {
		return productService.removeProduct(field, value);
	}

	public Boolean updateProduct(Product product) {
		return productService.updateProduct(product);
	}

	public HashMap<Integer, Product> findAll() {
		return productService.findAll();
	}

	public ArrayList<Product> findTopProducts() {
		LinkedHashMap<Long, Integer> tmp = basketService.findTopProducts();
		Object[] entries = tmp.entrySet().toArray();
		Map.Entry<Long, Integer> entry = null;
		ArrayList<Product> topProducts = new ArrayList<Product>();
		Product item = null;
		for (int i = (entries.length - 1); i >= 0; i--) {
			entry = (Map.Entry<Long, Integer>) entries[i];
			item = findProduct(entry.getValue());
			if (item != null) {
				topProducts.add(item);
			}
			if (i == 5) {
				break;
			}
		}
		return topProducts;
	}

	public Boolean addToBasket(Product item, Integer amount) {
		return basketService.addProduct(item.getId(), amount);
	}

	public Boolean addToBasket(Integer id, Integer amount) {
		if (findProduct(id) != null) {
			return basketService.addProduct(id, amount);
		}
		return false;
	}

	public Boolean removeFromBasket(Integer id) {
		if (findProduct(id) != null) {
			return basketService.removeProduct(id);
		}
		return false;
	}

	public Boolean removeFromBasket(Product item) {
		return basketService.removeProduct(item.getId());
	}

	public Boolean updateBasketProduct(Product item, Integer amount) {
		return basketService.removeProduct(item.getId());
	}

	public Boolean updateBasketProduct(Integer id, Integer amount) {
		if (findProduct(id) != null) {
			return basketService.updateProduct(id, amount);
		}
		return false;
	}

	public HashMap<Integer, Integer> getBasketProducts() {
		return basketService.findAll();
	}

	public Boolean clearBasket() {
		return basketService.removeAll();
	}

}
