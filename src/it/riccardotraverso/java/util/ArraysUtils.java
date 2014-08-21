/*
 * Copyright (C) 2014 Riccardo Traverso
 * 
 * This file is part of JavaUtils
 * Website: https://github.com/rtraverso86/JavaUtils
 * 
 * JavaUtils is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JavaUtils is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package it.riccardotraverso.java.util;

import java.util.Arrays;

public class ArraysUtils {

	private ArraysUtils() {
		// Class not instantiable
	}

	/**
	 * Generates a string composed of just n consecutive occurrences of char c.
	 * 
	 * @param n
	 * @param c
	 */
	public static char[] replicate(int n, char c) {
		char chars[] = new char[n];
		Arrays.fill(chars, c);
		return chars;
	}

	/**
	 * Searches for an element in an array, returning its index if present. The
	 * objects in the array are first compared by reference with the given
	 * object, and then by means of the equals() method.
	 * 
	 * @param arr
	 *            the array to search in
	 * @param obj
	 *            the object to search for in the given array
	 * @return the index of the given object in the array if it is present, or
	 *         -1 otherwise
	 */
	public static <T> int find(T[] arr, T obj) {
		for (int idx = 0; idx < arr.length; idx++) {
			T t = arr[idx];
			if (t == obj || t.equals(obj)) {
				return idx;
			}
		}
		return -1;
	}
	
	/**
	 * @see #find(Object[], Object)
	 */
	public static int find(byte[] arr, byte b) {
		for (int idx = 0; idx < arr.length; idx++) {
			byte t = arr[idx];
			if (t == b) {
				return idx;
			}
		}
		return -1;
	}
	
	/**
	 * @see #find(Object[], Object)
	 */
	public static int find(short[] arr, short s) {
		for (int idx = 0; idx < arr.length; idx++) {
			short t = arr[idx];
			if (t == s) {
				return idx;
			}
		}
		return -1;
	}
	
	/**
	 * @see #find(Object[], Object)
	 */
	public static int find(boolean[] arr, boolean b) {
		for (int idx = 0; idx < arr.length; idx++) {
			boolean t = arr[idx];
			if (t == b) {
				return idx;
			}
		}
		return -1;
	}
	
	/**
	 * @see #find(Object[], Object)
	 */
	public static int find(char[] arr, char c) {
		for (int idx = 0; idx < arr.length; idx++) {
			char t = arr[idx];
			if (t == c) {
				return idx;
			}
		}
		return -1;
	}
	
	/**
	 * @see #find(Object[], Object)
	 */
	public static int find(int[] arr, int i) {
		for (int idx = 0; idx < arr.length; idx++) {
			int t = arr[idx];
			if (t == i) {
				return idx;
			}
		}
		return -1;
	}
	
	/**
	 * @see #find(Object[], Object)
	 */
	public static int find(long[] arr, long l) {
		for (int idx = 0; idx < arr.length; idx++) {
			long t = arr[idx];
			if (t == l) {
				return idx;
			}
		}
		return -1;
	}
	
	/**
	 * @see #find(Object[], Object)
	 */
	public static int find(float[] arr, float f) {
		for (int idx = 0; idx < arr.length; idx++) {
			float t = arr[idx];
			if (t == f) {
				return idx;
			}
		}
		return -1;
	}
	
	/**
	 * @see #find(Object[], Object)
	 */
	public static int find(double[] arr, double d) {
		for (int idx = 0; idx < arr.length; idx++) {
			double t = arr[idx];
			if (t == d) {
				return idx;
			}
		}
		return -1;
	}

	/**
	 * Tells whether an element is present in an array. The objects in the array
	 * are first compared by reference with the given object, and then by means
	 * of the equals() method.
	 * 
	 * @param arr
	 *            the array to search in
	 * @param obj
	 *            the object to search for in the given array
	 * @return true iff the object is present in the given array
	 */
	public static <T> boolean contains(T[] arr, T obj) {
		return find(arr, obj) >= 0;
	}
	
	/**
	 *@see #contains(Object[], Object)
	 */
	public static boolean contains(byte[] arr, byte obj) {
		return find(arr, obj) >= 0;
	}
	
	/**
	 *@see #contains(Object[], Object)
	 */
	public static boolean contains(short[] arr, short obj) {
		return find(arr, obj) >= 0;
	}
	
	/**
	 *@see #contains(Object[], Object)
	 */
	public static boolean contains(boolean[] arr, boolean obj) {
		return find(arr, obj) >= 0;
	}
	
	/**
	 *@see #contains(Object[], Object)
	 */
	public static boolean contains(char[] arr, char obj) {
		return find(arr, obj) >= 0;
	}
	
	/**
	 *@see #contains(Object[], Object)
	 */
	public static boolean contains(int[] arr, int obj) {
		return find(arr, obj) >= 0;
	}
	
	/**
	 *@see #contains(Object[], Object)
	 */
	public static boolean contains(long[] arr, long obj) {
		return find(arr, obj) >= 0;
	}
	
	/**
	 *@see #contains(Object[], Object)
	 */
	public static boolean contains(float[] arr, float obj) {
		return find(arr, obj) >= 0;
	}
	
	/**
	 *@see #contains(Object[], Object)
	 */
	public static boolean contains(double[] arr, double obj) {
		return find(arr, obj) >= 0;
	}

}
