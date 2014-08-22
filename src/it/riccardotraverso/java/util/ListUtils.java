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

package it.riccardotraverso.java.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ListUtils {

	private ListUtils() {
		// Not instantiable class
	}

	/**
	 * It copies list src onto dst in reversed order, eventually clearing the
	 * destination list dst beforehand.
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

	/**
	 * Creates a shuffled list where each and every number in the range between
	 * <code>min</code> and <code>max</code> appear exactly once.
	 * 
	 * @param min
	 * @param max
	 */
	public static List<Integer> pickNDistinctRandom(int min, int max) {
		ArrayList<Integer> result = new ArrayList<Integer>(max - min + 1);
		while (min++ < max) {
			result.add(min);
		}
		Collections.shuffle(result);
		return result;
	}

	/**
	 * Picks <code>count</code> distinct random numbers in the range between
	 * <code>min</code> and <code>max</code>, included.
	 * 
	 * @param min
	 * @param max
	 * @param count
	 */
	public static List<Integer> pickNDistinctRandom(int min, int max, int count) {
		return pickNDistinctRandom(min, max).subList(0, count);
	}

}
