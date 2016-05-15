package com.epam.pp.hasan.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public class Order {
	private List<Product> items;
	/**
	 * @return the items
	 */
	public final List<Product> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public final void setItems(List<Product> items) {
		this.items = items;
	}

	/**
	 * Total price.
	 */
	private Integer totalPrice;
	/**
	 * Status.
	 */
	private OrderStatus status;

	public Order() {
		items = new ArrayList<Product>();
	}

	public final void addProduct(Product item) {
		if (item != null) {
			items.add(item);
		}
	}

	public final void removeProduct(Product item) {
		if (item != null) {
			items.remove(item);
		}
	}

	public final void removeProduct(Integer index) {
		if (index != null && index > 0) {
			items.remove(index);
		}
	}

	@Override
	public String toString() {
		return "Basket [items=" + items + ", totalPrice=" + totalPrice + ", status=" + status
				+ "]";
	}

	public final OrderStatus getStatus() {
		return status;
	}

	public final void setStatus(final OrderStatus status) {
		this.status = status;
	}

	public final Integer getTotalPrice() {
		return totalPrice;
	}

	public final void setTotalPrice(final Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

}
