package com.epam.pp.hasan.strategy;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.epam.pp.hasan.annotations.ProductAnnotation;
import com.epam.pp.hasan.entities.Product;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public class GenerateRefl implements ProductStrategy {
	private String PATH = "com.epam.pp.hasan.entities.";
	private HashMap<Integer, String> products;

	/**
	 * 
	 * @param products
	 *            products
	 */
	public GenerateRefl(HashMap<Integer, String> products) {
		this.products = products;
	}

	@Override
	public Product addProduct() {
		int size = products.size();
		int opt = (int) (Math.random() * 10) % size;
		String item = products.get(opt);
		try {
			Class clazz = Class.forName(PATH + item);
			Object obj = clazz.newInstance();
			while (clazz != Object.class) {
				Method[] methods = clazz.getDeclaredMethods();
				for (Method m : methods) {
					if (m.isAnnotationPresent(ProductAnnotation.class)) {
						ProductAnnotation ann = m.getAnnotation(ProductAnnotation.class);
						Object arg = generateObject(ann.type());
						m.invoke(obj, arg);
					}
				}
				clazz = clazz.getSuperclass();
			}
			return (Product) obj;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	private Object generateObject(String type) {
		Object input = null;
		if (type.contains("Integer")) {
			input = (int) (Math.random() * 10000);
			return input;
		}
		if (type.contains("Double")) {
			input = Math.random() * 100000;
			return input;
		}
		if (type.contains("String") || type.contains("Text")) {
			input = "Product text " + Math.random() * 1000;
			return input;
		}
		return input;
	}

}
