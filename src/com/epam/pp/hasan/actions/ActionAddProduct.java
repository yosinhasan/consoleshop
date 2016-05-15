package com.epam.pp.hasan.actions;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.entities.Product;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.strategy.AddProduct;
import com.epam.pp.hasan.utils.Request;

public class ActionAddProduct extends Action {
	public ActionAddProduct(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		AddProduct helper = (AddProduct) request.get("helper");
		Product item = helper.getGeneratedProduct();
		request.set("isAdded",productFacade.addProduct(item));
		return Fields.ACTION_ADD_PRODUCT;
	}
}
