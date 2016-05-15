package com.epam.pp.hasan.actions;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.utils.ConsoleHelper;
import com.epam.pp.hasan.utils.Request;

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
