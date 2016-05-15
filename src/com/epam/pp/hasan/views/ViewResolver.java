/**
 * 
 */
package com.epam.pp.hasan.views;

import java.util.Map;
import java.util.TreeMap;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.utils.Request;

/**
 * @author Yosin_Hasan
 *
 */
public final class ViewResolver {
	private Map<String, View> views = new TreeMap<String, View>();
	/**
	 * 
	 * @param views
	 *            views container
	 */
	public ViewResolver(Map<String, View> views) {
		this.views = views;
	}

	/**
	 * View resolver.
	 * 
	 * @param name
	 *            view name
	 * @param request
	 *            request
	 */
	public void resolve(String name, Request request) {
		View view = get(name);
		view.view(request);
	}

	private View get(final String name) {
		if (name == null || !views.containsKey(name)) {
			return views.get(Fields.ACTION_NOTFOUND);
		}
		return views.get(name);
	}
}
