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
	 * @return
	 */
	public static char[] replicate(int n, char c) {
		char chars[] = new char[n];
		Arrays.fill(chars, c);
		return chars;
	}

}
