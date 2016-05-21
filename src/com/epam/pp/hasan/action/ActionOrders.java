package com.epam.pp.hasan.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.Request;

public class ActionOrders extends Action {

	public ActionOrders(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		request.set("orders", productFacade.findAllOrders());
		return Fields.ACTION_ORDERS;
	}

}
