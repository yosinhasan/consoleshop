package com.epam.pp.hasan.strategy;

import com.epam.pp.hasan.annotations.ProductAnnotation;
import com.epam.pp.hasan.entities.Product;
import com.epam.pp.hasan.utils.ConsoleHelper;
import com.epam.pp.hasan.utils.Validator;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.ResourceBundle;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public class ConsoleRefl implements ProductStrategy {
	private String PROPERTIES_FILE = "lang";
	private String PATH = "com.epam.pp.hasan.entities.";
	private HashMap<Integer, String> products;

	/**
	 * 
	 * @param products
	 *            products
	 */
	public ConsoleRefl(HashMap<Integer, String> products) {
		this.products = products;
	}

	private void showProducts() {
		Iterator<Entry<Integer, String>> iter = products.entrySet().iterator();
		Entry<Integer, String> item = null;
		while (iter.hasNext()) {
			item = iter.next();
			System.out.println("=>" + item.getKey() + ": " + item.getValue());
		}
	}

	@Override
	public Product addProduct() {
		ResourceBundle rb = ResourceBundle.getBundle(PROPERTIES_FILE);
		System.out.println("What do you want to add?");
		showProducts();
		Integer opt = ConsoleHelper.getInt("Choose one: ");
		String item = products.get(opt);
		try {
			Class clazz = Class.forName(PATH + item);
			Object obj = clazz.newInstance();
			while (clazz != Object.class) {
				Method[] methods = clazz.getDeclaredMethods();
				for (Method m : methods) {
					if (m.isAnnotationPresent(ProductAnnotation.class)) {
						ProductAnnotation ann = m.getAnnotation(ProductAnnotation.class);
						System.out.println(rb.getString(ann.resourse()));
						Object arg = ConsoleHelper.get(ann.type());
						if (Validator.isValid(arg, ann.type())) {
							m.invoke(obj, arg);
						} else {
							throw new Exception("Invalid argument");
						}
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

}
