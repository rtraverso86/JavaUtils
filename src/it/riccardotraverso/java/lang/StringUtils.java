package it.riccardotraverso.java.lang;

import it.riccardotraverso.java.util.ArraysUtils;

import java.util.Iterator;

public class StringUtils {

	private StringUtils() {
		// Class not instantiable
	}

	/**
	 * Generates a string composed of just n consecutive occurrences of char c.
	 * 
	 * @param n
	 * @param c
	 * @return
	 */
	public static String replicate(int n, char c) {
		return new String(ArraysUtils.replicate(n, c));
	}

	/**
	 * Generates a string composed of n consecutive occurrences of the string s.
	 * 
	 * @param n
	 * @param s
	 * @return
	 */
	public static String replicate(int n, String s) {
		java.lang.StringBuilder b = new java.lang.StringBuilder();
		for (; n > 0; --n) {
			b.append(s);
		}
		return b.toString();
	}

	/**
	 * Generates a string composed of n consecutive occurrences of the string s.
	 * 
	 * @param n
	 * @param s
	 * @return
	 */
	public static String replicate(int n, String s) {
		java.lang.StringBuilder b = new java.lang.StringBuilder();
		for (; n > 0; --n) {
			b.append(s);
		}
		return b.toString();
	}

	/**
	 * Returns true iff s is either null or the empty string.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isBlank(String s) {
		return s == null || s.isEmpty();
	}

	/**
	 * Returns the empty string when s is null, or s as is otherwise.
	 * 
	 * @param s
	 * @return
	 */
	public static String nullAsEmpty(String s) {
		return s == null ? "" : s;
	}

	/**
	 * Returns null when s is the empty string, or s as is otherwise.
	 * 
	 * @param s
	 * @return
	 */
	public static String emptyAsNull(String s) {
		return isBlank(s) ? null : s;
	}

	/**
	 * Joins into a string an array of objects by using a separator.
	 * 
	 * @param arr
	 * @param separator
	 * @return
	 */
	public static String join(Object[] arr, String separator) {
		if (arr == null || arr.length < 1)
			return "";
		StringBuilder sb = new StringBuilder(arr[0].toString());
		for (int i = 1; i < arr.length; ++i) {
			sb.append(separator);
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	/**
	 * Joins into a string an iterable collection of objects by using a
	 * separator.
	 * 
	 * @param coll
	 * @param separator
	 * @return
	 */
	public static <T> String join(Iterable<T> coll, String separator) {
		if (coll == null)
			return "";
		Iterator<T> it = coll.iterator();
		if (!it.hasNext())
			return "";
		StringBuilder sb = new StringBuilder(it.next().toString());
		while (it.hasNext()) {
			sb.append(separator);
			sb.append(it.next());
		}
		return sb.toString();
	}

	/**
	 * Capitalizes the very first character of a given string.
	 * 
	 * @param s
	 * @return
	 */
	public static String capitalize(String s) {
		if (s == null || s.isEmpty())
			return s;
		StringBuilder builder = new StringBuilder();
		builder.append(Character.toUpperCase(s.charAt(0)));
		builder.append(s.substring(1));
		return builder.toString();
	}

}
