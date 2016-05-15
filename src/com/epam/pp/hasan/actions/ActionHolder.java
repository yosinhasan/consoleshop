package com.epam.pp.hasan.actions;

import java.util.Map;
import java.util.TreeMap;

public final class ActionHolder {
	private  Map<Integer, Action> actions = new TreeMap<Integer, Action>();
	/**
	 * Public constructor.
	 */
	public ActionHolder(Map<Integer, Action> actions) {
		this.actions = actions;

	}
	/**
	 * Get action from container.
	 * 
	 * @param action
	 * @return
	 */
	public Action get(final Integer action) {
		if (action == null || !actions.containsKey(action)) {
			return actions.get(404);
		}
		return actions.get(action);
	}

}
