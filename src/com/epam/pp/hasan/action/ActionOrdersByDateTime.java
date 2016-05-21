package com.epam.pp.hasan.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.ConsoleHelper;
import com.epam.pp.hasan.util.Request;

public class ActionOrdersByDateTime extends Action {
	public ActionOrdersByDateTime(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		String date = ConsoleHelper.getDateStr("Input date (yyyy-mm-dd):");
		request.set("date", date);
		request.set("orders", productFacade.findOrders(date));
		return Fields.ACTION_ORDERS_BY_DATETIME;
	}

}
