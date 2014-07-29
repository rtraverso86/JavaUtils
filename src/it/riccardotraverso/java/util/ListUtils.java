package it.riccardotraverso.java.util;

import java.util.List;
import java.util.ListIterator;

public class ListUtils {

	private ListUtils() {
		// Not instantiable class
	}
	
	/**
	 * It copies list src onto dst in reversed order, eventually clearing
	 * the destination list dst beforehand.
	 * 
	 * @param src
	 * @param dst
	 */
	public static <T> void reverse(List<T> src, List<T> dst) {
		if (!dst.isEmpty())
			dst.clear();
		ListIterator<T> lstIt = src.listIterator(src.size());
		while (lstIt.hasPrevious()) {
			dst.add(lstIt.previous());
		}
	}

}
