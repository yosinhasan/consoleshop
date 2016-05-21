package com.epam.pp.hasan.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.Request;

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
