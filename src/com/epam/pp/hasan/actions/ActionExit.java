package com.epam.pp.hasan.actions;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.utils.Request;

public class ActionExit extends Action {

	public ActionExit(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		request.clear();
		return Fields.ACTION_EXIT;
	}

}
