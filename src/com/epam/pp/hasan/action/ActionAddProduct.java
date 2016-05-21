package com.epam.pp.hasan.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.entity.Computer;
import com.epam.pp.hasan.entity.Product;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.strategy.AddProduct;
import com.epam.pp.hasan.util.ConsoleHelper;
import com.epam.pp.hasan.util.ProductHelper;
import com.epam.pp.hasan.util.Request;

import java.util.ResourceBundle;

public class ActionAddProduct extends Action {
	public ActionAddProduct(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		AddProduct helper = (AddProduct) request.get("helper");
		ProductHelper productHelper = (ProductHelper) request.get("productHelper");
		Product item = helper.getGeneratedProduct(productHelper.getProductType());
		request.set("isAdded",productFacade.addProduct(item));
		return Fields.ACTION_ADD_PRODUCT;
	}
}
