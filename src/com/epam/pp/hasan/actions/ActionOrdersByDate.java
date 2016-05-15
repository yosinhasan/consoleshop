package com.epam.pp.hasan.actions;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.utils.ConsoleHelper;
import com.epam.pp.hasan.utils.Request;

public class ActionOrdersByDate extends Action {
	public ActionOrdersByDate(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		Long startDate = ConsoleHelper.getDate(false, "Input start date(yyyy-mm-dd):");
		Long endDate = ConsoleHelper.getDate(true, "Input end date(yyyy-mm-dd):");
		request.set("startDate", startDate);
		request.set("endDate", endDate);
		request.set("orders", productFacade.findOrders(startDate, endDate));
		return Fields.ACTION_ORDERS_BY_DATE;
	}

}
