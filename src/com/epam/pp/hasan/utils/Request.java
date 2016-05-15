/**
 * 
 */
package com.epam.pp.hasan.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yosin_Hasan
 *
 */
public final class Request {
	private Map<String, Object> storage;

	public Request() {
		storage = new HashMap<String, Object>();
	}

	/**
	 * Set argument.
	 * 
	 * @param key
	 *            key
	 * @param value
	 *            value
	 */
	public void set(String key, Object value) {
		storage.put(key, value);

	}

	/**
	 * Remove from storage by key.
	 * 
	 * @param key
	 *            key
	 */
	public void remove(String key) {
		if (key != null && !key.isEmpty()) {
			if (storage.containsKey(key)) {
				storage.remove(key);
			}
		}
	}

	/**
	 * Get from storage by key.
	 * 
	 * @param key
	 *            key
	 * @return Object
	 */
	public Object get(String key) {
		if (key != null && !key.isEmpty()) {
			if (storage.containsKey(key)) {
				return storage.get(key);
			}
		}
		return null;
	}

	/**
	 * Clear storage.
	 */
	public void clear() {
		storage.clear();
	}
}
