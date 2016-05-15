package com.epam.pp.hasan.strategy;

import com.epam.pp.hasan.entities.Product;
import com.epam.pp.hasan.utils.ConsoleHelper;
import com.epam.pp.hasan.utils.Validator;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public class Console implements ProductStrategy {

	@Override
	public Product addProduct() {
		Product newProd = new Product();
		String name = ConsoleHelper.getText("Input product name: ");
		if (!Validator.isValidString(name) || !Validator.isValidLength(name, 4, 20)) {
			throw new IllegalArgumentException("Inputted value of name has invalid format. ");
		}
		String description = ConsoleHelper.getText("Input product description: ");
		if (!Validator.isValidString(description) || !Validator.isValidLength(description, 80)) {
			throw new IllegalArgumentException("Inputted value of description has invalid format. ");
		}
		Integer price = ConsoleHelper.getInt("Input product price: ");
		if (!Validator.isValidNumber(price)) {
			throw new IllegalArgumentException("Inputted value of price has invalid format. ");
		}

		newProd.setName(name);
		newProd.setDescription(description);
		newProd.setPrice(price);
		return newProd;
	}

}
