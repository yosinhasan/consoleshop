package com.epam.pp.hasan.network.actions;

import java.util.Map;
import java.util.TreeMap;

public final class ActionHolder {
	private  Map<String, Action> actions = new TreeMap<String, Action>();
	/**
	 * Public constructor.
	 */
	public ActionHolder(Map<String, Action> actions) {
		this.actions = actions;

	}
	/**
	 * Get action from container.
	 *
	 * @param action
	 * @return
	 */
	public Action get(final String action) {
		if (action == null || !actions.containsKey(action)) {
			return actions.get("notfound");
		}
		return actions.get(action);
	}

}
