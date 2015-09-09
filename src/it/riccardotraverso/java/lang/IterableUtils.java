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

import java.util.Iterator;

public class IterableUtils {

	private IterableUtils() {
		// Not instantiable class
	}

	/**
	 * Executes a strategy <code>s</code> on each element of the collection
	 * <code>coll</code>, in the same order as its corresponding iterator.
	 * 
	 * @param coll
	 * @param s
	 * @return the result obtained from the application of the strategy to the
	 *         last element
	 */
	public static <T, O> O execute(Iterable<T> coll, Strategy<T, O> s) {
		for (T val : coll) {
			s.execute(val);
		}
		return s.getLastResult();
	}

	/**
	 * Returns a new iterable object which relies on the {@link MultiIterator}
	 * class to generate iterators lazily aggregating the objects in the given
	 * sequence of iterable objects.
	 * 
	 * @see MultiIterator#MultiIterator(Iterable...)
	 */
	public static <T> Iterable<T> it(final Iterable<? extends T>... its) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new MultiIterator<T>(its);
			}
		};
	}


	/**
	 * Returns a new iterable object which relies on the {@link MultiIterator}
	 * class to generate iterators lazily aggregating the objects in the given
	 * sequence of iterable objects.
	 * 
	 * @see MultiIterator#MultiIterator(Iterable, Iterable)
	 */
	public static <T> Iterable<T> it(final Iterable<? extends T> i1,
			final Iterable<? extends T> i2) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new MultiIterator<T>(i1, i2);
			}
		};
	}


	/**
	 * Returns a new iterable object which relies on the {@link MultiIterator}
	 * class to generate iterators lazily aggregating the objects in the given
	 * sequence of iterable objects.
	 * 
	 * @see MultiIterator#MultiIterator(Iterable, Iterable, Iterable)
	 */
	public static <T> Iterable<T> it(final Iterable<? extends T> i1,
			final Iterable<? extends T> i2, final Iterable<? extends T> i3) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new MultiIterator<T>(i1, i2, i3);
			}
		};
	}


	/**
	 * Returns a new iterable object which relies on the {@link MultiIterator}
	 * class to generate iterators lazily aggregating the objects in the given
	 * sequence of iterable objects.
	 * 
	 * @see MultiIterator#MultiIterator(Iterable, Iterable, Iterable, Iterable)
	 */
	public static <T> Iterable<T> it(final Iterable<? extends T> i1,
			final Iterable<? extends T> i2, final Iterable<? extends T> i3,
			final Iterable<? extends T> i4) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new MultiIterator<T>(i1, i2, i3, i4);
			}
		};
	}


	/**
	 * Returns a new iterable object which relies on the {@link MultiIterator}
	 * class to generate iterators lazily aggregating the objects in the given
	 * sequence of iterable objects.
	 * 
	 * @see MultiIterator#MultiIterator(Iterable, Iterable, Iterable, Iterable, Iterable)
	 */
	public static <T> Iterable<T> it(final Iterable<? extends T> i1,
			final Iterable<? extends T> i2, final Iterable<? extends T> i3,
			final Iterable<? extends T> i4, final Iterable<? extends T> i5) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new MultiIterator<T>(i1, i2, i3, i4, i5);
			}
		};
	}


	/**
	 * Returns a new iterable object which relies on the {@link MultiIterator}
	 * class to generate iterators lazily aggregating the objects in the given
	 * sequence of iterable objects.
	 * 
	 * @see MultiIterator#MultiIterator(Iterable, Iterable, Iterable, Iterable, Iterable, Iterable)
	 */
	public static <T> Iterable<T> it(final Iterable<? extends T> i1,
			final Iterable<? extends T> i2, final Iterable<? extends T> i3,
			final Iterable<? extends T> i4, final Iterable<? extends T> i5,
			final Iterable<? extends T> i6) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new MultiIterator<T>(i1, i2, i3, i4, i5, i6);
			}
		};
	}
	

	/**
	 * Returns a new iterable object which relies on the {@link MultiIterator}
	 * class to generate iterators lazily aggregating the objects in the given
	 * sequence of iterable objects.
	 * 
	 * @see MultiIterator#MultiIterator(Iterable, Iterable, Iterable, Iterable, Iterable, Iterable, Iterable)
	 */
	public static <T> Iterable<T> it(final Iterable<? extends T> i1,
			final Iterable<? extends T> i2, final Iterable<? extends T> i3,
			final Iterable<? extends T> i4, final Iterable<? extends T> i5,
			final Iterable<? extends T> i6, final Iterable<? extends T> i7) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new MultiIterator<T>(i1, i2, i3, i4, i5, i6, i7);
			}
		};
	}

}
