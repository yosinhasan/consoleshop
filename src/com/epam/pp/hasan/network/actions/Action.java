package com.epam.pp.hasan.network.actions;

import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.utils.Request;

public abstract class Action {
	protected ConsoleProductFacade facade;

	public Action(ConsoleProductFacade facade) {
		this.facade = facade;
	}

	/**
	 * Executing action.
	 */
	public abstract String execute(Request request);
}
