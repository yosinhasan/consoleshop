package com.epam.pp.hasan.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.Request;

public class ActionProducts extends Action {
	public ActionProducts(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		request.set("products", productFacade.findAll());
		return Fields.ACTION_PRODUCTS;
	}

}
