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

package it.riccardotraverso.java.io;

import java.io.Closeable;
import java.io.IOException;

public class CloseableUtils {

	private CloseableUtils() {
		// No instances
	}
	
	/**
	 * Closes a Closeable object without raising exceptions.
	 * 
	 * @param input
	 * @return The raised exception, if any.
	 */
	public static IOException closeQuietly(Closeable input) {
		try {
			if (input != null)
				input.close();
			return null;
		} catch (IOException e) {
			return e;
		}
	}
}
