package com.epam.pp.hasan.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.ConsoleHelper;
import com.epam.pp.hasan.util.Request;

public class ActionProduct extends Action {
	public ActionProduct(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		Integer code = ConsoleHelper.getInt("Input product code:");
		request.set("product", productFacade.findProduct(code));
		return Fields.ACTION_PRODUCT;
	}

}
