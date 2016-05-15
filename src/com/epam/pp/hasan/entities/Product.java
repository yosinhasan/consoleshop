/**
 * 
 */
package com.epam.pp.hasan.entities;

import com.epam.pp.hasan.annotations.ProductAnnotation;

/**
 * @author Yosin_Hasan
 *
 */
public class Product {
	private Integer id;
	private String name;
	private String description;
	private Integer price;
	private Integer quantity;

	public final Integer getQuantity() {
		return quantity;
	}

	public final void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}

	public Product() {

	}

	/**
	 * Constructor with arguments.
	 * 
	 * @param id
	 *            product code
	 * @param name
	 *            product name
	 * @param description
	 *            product description
	 * @param price
	 *            price
	 * @param quantity
	 *            quantity
	 */
	public Product(final Integer id, final String name, final String description, final Integer price,
			final Integer quantity) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(final Integer id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	@ProductAnnotation(resourse = "name", type = "String")
	public final void setName(final String name) {
		this.name = name;
	}

	public final String getDescription() {
		return description;
	}

	@ProductAnnotation(resourse = "description", type = "Text")
	public final void setDescription(final String description) {
		this.description = description;
	}

	public final Integer getPrice() {
		return price;
	}

	@ProductAnnotation(resourse = "price", type = "Integer")
	public final void setPrice(final Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id = " + id + ", name=" + name + ", price=" + price + "]";
	}

}
