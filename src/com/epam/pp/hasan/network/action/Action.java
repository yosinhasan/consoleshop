package com.epam.pp.hasan.network.action;

import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.Request;

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
