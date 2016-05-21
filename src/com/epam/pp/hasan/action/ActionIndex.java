package com.epam.pp.hasan.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.Request;

public class ActionIndex extends Action {
	public ActionIndex(ConsoleProductFacade productFacade) {
		super(productFacade);
	}

	@Override
	public String execute(Request request) {
		return Fields.ACTION_INDEX;
	}

}
