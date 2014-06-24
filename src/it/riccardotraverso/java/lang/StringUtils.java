package it.riccardotraverso.java.lang;

import it.riccardotraverso.java.util.ArraysUtils;

import java.lang.String;
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
	 * Joins into a string an array of objects by using a separator.
	 * 
	 * @param arr
	 * @param separator
	 * @return
	 */
	public static String join(Object[] arr, String separator) {
		if (arr == null || arr.length < 1) return "";
		StringBuilder sb = new StringBuilder(arr[0].toString());
		for (int i = 1; i < arr.length; ++i) {
			sb.append(separator);
			sb.append(arr[i]);
		}
		return sb.toString();
	}
	
	/**
	 * Joins into a string an iterable collection of objects by using a separator.
	 * 
	 * @param i
	 * @param separator
	 * @return
	 */
	public static <T> String join(Iterable<T> i, String separator) {
		if (i == null) return "";
		Iterator<T> it = i.iterator();
		if (!it.hasNext()) return "";
		StringBuilder sb = new StringBuilder(it.next().toString());
		while (it.hasNext()) {
			sb.append(separator);
			sb.append(it.next());
		}
		return sb.toString();
	}

}
