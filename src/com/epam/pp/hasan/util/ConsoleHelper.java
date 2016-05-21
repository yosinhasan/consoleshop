package com.epam.pp.hasan.util;

import java.sql.Timestamp;
import java.util.Scanner;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public final class ConsoleHelper {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Get int from stdin.
	 * 
	 * @param str
	 *            message
	 * @return Integer
	 */
	public static final Integer getInt(String str) {
		Integer code = null;
		String input = null;
		System.out.println(str);
		while (sc.hasNext()) {
			input = sc.next();
			if (input.matches("[0-9]*")) {
				code = Integer.parseInt(input);
				if (code >= 0) {
					break;
				}
			} else {
				System.out.println("Illegal input argument, the argument must be integer format.");
			}

		}
		return code;

	}

	/**
	 * Get int from stdin.
	 * 
	 * @return Integer
	 */
	public static final Integer getInt() {
		Integer code = null;
		String input = null;
		while (sc.hasNext()) {
			input = sc.next();
			if (input.matches("[0-9]*")) {
				code = Integer.parseInt(input);
				if (code >= 0) {
					break;
				}
			} else {
				System.out.println("Illegal input argument, the argument must be integer format.");
			}

		}
		return code;

	}

	/**
	 * Get string from stdin.
	 * 
	 * @return String.
	 */
	public static final String getString() {
		String string = null;
		while (sc.hasNext()) {
			string = sc.next();
			if (string != null && !string.isEmpty()) {
				break;
			}
		}
		return string;
	}

	/**
	 * Get string from stdin.
	 * 
	 * @return String.
	 */
	public static final String getText() {
		String string = null;
		while (sc.hasNextLine()) {
			string = sc.nextLine();
			if (string != null && !string.isEmpty()) {
				break;
			}
		}
		return string;
	}

	/**
	 * Get string from stdin.
	 * 
	 * @param msg
	 *            message
	 * @return String.
	 */
	public static final String getText(String msg) {
		String string = null;
		System.out.println(msg);
		while (sc.hasNextLine()) {
			string = sc.nextLine();
			if (string != null && !string.isEmpty()) {
				break;
			}
		}
		return string;
	}

	/**
	 * Get long from stdin.
	 * 
	 * @return Long
	 */
	public static final Long getLong() {
		Long code = null;
		while (sc.hasNextLong()) {
			code = sc.nextLong();
			if (code >= 0) {
				break;
			}
		}
		return code;
	}

	/**
	 * Get date in long format from stdin.
	 * 
	 * @param end
	 *            whether to add 23:59:99 or not
	 * @param msg
	 *            message
	 * 
	 * @return Long
	 */
	public static final Long getDate(final Boolean end, final String msg) {
		Long date = null;
		String strdate = null;
		System.out.println(msg);
		while (sc.hasNext()) {
			strdate = sc.next();
			if (strdate != null && !strdate.isEmpty()) {
				if (strdate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
					break;
				} else {
					System.out.println("Illegal date format, must be yyyy-mm-dd");
				}
			} else {
				System.out.println("Incorrect data. Try again.");
			}
		}

		try {
			if (end.equals(false)) {
				date = Timestamp.valueOf(strdate + " 00:00:00").getTime();
			} else {
				date = Timestamp.valueOf(strdate + " 23:59:59").getTime();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal argument. Date must be yyyy-mm-dd format. Inputted argument: " + strdate);
		}
		return date;
	}

	/**
	 * Get date in string format from stdin.
	 * 
	 * @param msg
	 *            message
	 * @return String
	 */
	public static final String getDateStr(String msg) {
		String strdate = null;
		System.out.println(msg);
		while (sc.hasNext()) {
			strdate = sc.next();
			if (strdate != null && !strdate.isEmpty()) {
				if (strdate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
					break;
				} else {
					System.out.println("Illegal date format, must be yyyy-mm-dd");
				}
			} else {
				System.out.println("Incorrect data. Try again.");
			}
		}
		return strdate;
	}

	public static final Object get(String type) {
		Object input = null;
		if (type.contains("Integer")) {
			input = getInt();
			return input;
		}
		if (type.contains("Double")) {
			input = getDouble();
			return input;
		}
		if (type.contains("Long")) {
			input = getLong();
			return input;
		}
		if (type.contains("String")) {
			input = getString();
			return input;
		}
		if (type.contains("Text")) {
			input = getText();
			return input;
		}
		return input;
	}

	/**
	 * Get double from stdin.
	 * 
	 * @return Long
	 */
	public static final Double getDouble() {
		Double code = null;
		while (sc.hasNextDouble()) {
			code = sc.nextDouble();
			if (code >= 0) {
				break;
			}
		}
		return code;
	}
	public static final void show(String str) {
		System.out.println(str);
	}
}
