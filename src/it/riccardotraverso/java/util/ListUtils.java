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
