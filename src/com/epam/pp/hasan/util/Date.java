/**
 * 
 */
package com.epam.pp.hasan.util;

import java.sql.Timestamp;

/**
 * @author Yosin_Hasan
 *
 */
public final class Date {
	/**
	 * Get current time. Return milliseconds starting from epoch time.
	 * 
	 * @return Long
	 */
	public static final Long getCurrentTime() {
		Long time = System.currentTimeMillis();
		return time;
	}

	/**
	 * Get timestamp.
	 * 
	 * @param time
	 *            time
	 * @return String
	 */
	public static final String getTimestamp(final Long time) {
		return new Timestamp(time).toString();
	}

	/**
	 * Get milliseconds.
	 * 
	 * @param date
	 *            date
	 * @return Long
	 */
	public static final Long getMilliSeconds(final String date) {
		return Timestamp.valueOf(date).getTime();
	}
}
