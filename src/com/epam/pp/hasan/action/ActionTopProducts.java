package com.epam.pp.hasan.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.Request;

public class ActionTopProducts extends Action {

	public ActionTopProducts(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		request.set("top", productFacade.findTopProducts());
		return Fields.ACTION_TOP_PRODUCTS;
	}

}
