/*
 * Copyright (C) 2014 Riccardo Traverso
 * 
 * This file is part of JavaUtils
 * Website: https://github.com/rtraverso86/JavaUtils
 * 
 * JavaUtils is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JavaUtils is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
	 *            the number of repetitions of <code>c</code> 
	 * @param c
	 *            the character to be replicated
	 */
	public static String replicate(int n, char c) {
		return new String(ArraysUtils.replicate(n, c));
	}

	/**
	 * Generates a string composed of n consecutive occurrences of the string s.
	 * 
	 * @param n
	 *            the number of repetitions of <code>s</code>
	 * @param s
	 *            the string to be repeated
	 */
	public static String replicate(int n, String s) {
		StringBuilder b = new StringBuilder();
		for (; n > 0; --n) {
			b.append(s);
		}
		return b.toString();
	}

	/**
	 * Returns true iff s is either null or the empty string.
	 * 
	 * @param s the string to be tested
	 */
	public static boolean isBlank(String s) {
		return s == null || s.isEmpty();
	}

	/**
	 * Returns the empty string when s is null, or s as is otherwise.
	 */
	public static String nullAsEmpty(String s) {
		return s == null ? "" : s;
	}

	/**
	 * Returns null when s is the empty string, or s as is otherwise.
	 */
	public static String emptyAsNull(String s) {
		return isBlank(s) ? null : s;
	}

	/**
	 * Joins into a string an array of objects by using a separator.
	 * 
	 * @param arr
	 *            the array of elements to be converted in strings and joined
	 *            together
	 * @param separator
	 *            the separator to put in between any two adjacent strings
	 */
	public static String join(Object[] arr, String separator) {
		if (arr == null || arr.length < 1)
			return "";
		StringBuilder sb = new StringBuilder(arr[0].toString());
		for (int i = 1; i < arr.length; ++i) {
			if (!isBlank(separator)) {
				sb.append(separator);
			}
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	/**
	 * Joins into a string an iterable collection of objects by using a
	 * separator.
	 * 
	 * @param coll
	 *            the collection of elements to be converted in strings and
	 *            joined together
	 * @param separator
	 *            the separator to put in between any two adjacent strings*
	 */
	public static <T> String join(Iterable<T> coll, String separator) {
		if (coll == null)
			return "";
		Iterator<T> it = coll.iterator();
		if (!it.hasNext())
			return "";
		StringBuilder sb = new StringBuilder(it.next().toString());
		while (it.hasNext()) {
			if (!isBlank(separator)) { 
				sb.append(separator);
			}
			sb.append(it.next());
		}
		return sb.toString();
	}

	/**
	 * Capitalizes the very first character of a given string.
	 * 
	 * @param s
	 *            the string to be capitalized
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
