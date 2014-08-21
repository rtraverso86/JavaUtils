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
import java.util.NoSuchElementException;

/**
 * A <code>MultiIterator</code> collects a sequence of simple iterators in order to provide a
 * convenient way to navigate through each of them. <code>MultiIterator</code> returns each
 * element of each iterator, transparently moving to the next iterator as soon
 * as the one currently used does not have any more elements.
 * 
 * @param <E>
 *            The type of the elements iterated through by each of the collected
 *            iterators. It is not mandatory that individual iterators are
 *            exactly of type <code>Iterator&lt;E&gt;</code>, they might be of any
 *            other type <code>Iterator&lt;E1&gt;</code> as long as <code>E1</code>
 *            extends or implements <code>E</code>.
 */
public class MultiIterator<E> implements Iterator<E> {
	private Iterator<E> its[];
	private int idx = 0;

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in a variable
	 * number of iterators, such that each one is instantiated on a (possibly
	 * different) type parameter which is a subclass of <code>E</code>.
	 * 
	 * <p>
	 * <b>NOTE:</b> Invoking this constructor will cause a type safety warning,
	 * due to the use of generics with varargs. The warning can be safely
	 * suppressed by adding the annotation
	 * <code>@SuppressWarnings("unchecked")</code> at the call site.
	 * </p>
	 * 
	 * @param its
	 *            The iterators, each with its own type
	 *            <code>Iterator&lt;? extends E&gt;</code>.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterator<? extends E>... its) {
		super();
		if (its.length < 2)
			throw new IllegalArgumentException(
					"at least two iterators are required");
		this.its = (Iterator<E>[]) its;
	}

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterators in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterator
	 * @param i2
	 *            The second iterator
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterator<? extends E> i1, Iterator<? extends E> i2) {
		this.its = (Iterator<E>[]) new Iterator[2];
		its[0] = (Iterator<E>) i1;
		its[1] = (Iterator<E>) i2;
	}

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterators in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * 
	 * @param i1
	 *            The first iterator
	 * @param i2
	 *            The second iterator
	 * @param i3
	 *            The third iterator
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterator<? extends E> i1, Iterator<? extends E> i2,
			Iterator<? extends E> i3) {
		this.its = (Iterator<E>[]) new Iterator[3];
		its[0] = (Iterator<E>) i1;
		its[1] = (Iterator<E>) i2;
		its[2] = (Iterator<E>) i3;
	}

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterators in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterator
	 * @param i2
	 *            The second iterator
	 * @param i3
	 *            The third iterator
	 * @param i4
	 *            The fourth iterator
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterator<? extends E> i1, Iterator<? extends E> i2,
			Iterator<? extends E> i3, Iterator<? extends E> i4) {
		this.its = (Iterator<E>[]) new Iterator[4];
		its[0] = (Iterator<E>) i1;
		its[1] = (Iterator<E>) i2;
		its[2] = (Iterator<E>) i3;
		its[3] = (Iterator<E>) i4;
	}

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterators in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterator
	 * @param i2
	 *            The second iterator
	 * @param i3
	 *            The third iterator
	 * @param i4
	 *            The fourth iterator
	 * @param i5
	 *            The fifth iterator
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterator<? extends E> i1, Iterator<? extends E> i2,
			Iterator<? extends E> i3, Iterator<? extends E> i4,
			Iterator<? extends E> i5) {
		this.its = (Iterator<E>[]) new Iterator[5];
		its[0] = (Iterator<E>) i1;
		its[1] = (Iterator<E>) i2;
		its[2] = (Iterator<E>) i3;
		its[3] = (Iterator<E>) i4;
		its[4] = (Iterator<E>) i5;
	}

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterators in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterator
	 * @param i2
	 *            The second iterator
	 * @param i3
	 *            The third iterator
	 * @param i4
	 *            The fourth iterator
	 * @param i5
	 *            The fifth iterator
	 * @param i6
	 *            The sixth iterator
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterator<? extends E> i1, Iterator<? extends E> i2,
			Iterator<? extends E> i3, Iterator<? extends E> i4,
			Iterator<? extends E> i5, Iterator<? extends E> i6) {
		this.its = (Iterator<E>[]) new Iterator[6];
		its[0] = (Iterator<E>) i1;
		its[1] = (Iterator<E>) i2;
		its[2] = (Iterator<E>) i3;
		its[3] = (Iterator<E>) i4;
		its[4] = (Iterator<E>) i5;
		its[5] = (Iterator<E>) i6;
	}

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterators in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterator
	 * @param i2
	 *            The second iterator
	 * @param i3
	 *            The third iterator
	 * @param i4
	 *            The fourth iterator
	 * @param i5
	 *            The fifth iterator
	 * @param i6
	 *            The sixth iterator
	 * @param i7
	 *            The seventh iterator
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterator<? extends E> i1, Iterator<? extends E> i2,
			Iterator<? extends E> i3, Iterator<? extends E> i4,
			Iterator<? extends E> i5, Iterator<? extends E> i6,
			Iterator<? extends E> i7) {
		this.its = (Iterator<E>[]) new Iterator[7];
		its[0] = (Iterator<E>) i1;
		its[1] = (Iterator<E>) i2;
		its[2] = (Iterator<E>) i3;
		its[3] = (Iterator<E>) i4;
		its[4] = (Iterator<E>) i5;
		its[5] = (Iterator<E>) i6;
		its[6] = (Iterator<E>) i7;
	}

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in a variable
	 * number of iterable objects, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * <p>
	 * <b>NOTE:</b> Invoking this constructor will cause a type safety warning,
	 * due to the use of generics with varargs. The warning can be safely
	 * suppressed by adding the annotation
	 * <code>@SuppressWarnings("unchecked")</code> at the call site.
	 * </p>
	 * 
	 * @param its
	 *            The iterators, each with its own type
	 *            <code>Iterable&lt;? extends E&gt;</code>.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterable<? extends E>... its) {
		super();
		if (its.length < 2)
			throw new IllegalArgumentException(
					"at least two iterators are required");
		this.its = (Iterator<E>[]) new Iterator[its.length];
		for (int i = 0; i < its.length; i++) {
			this.its[i] = (Iterator<E>) its[i].iterator();
		}
	}
	
	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterable elements in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterable
	 * @param i2
	 *            The second iterable
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterable<? extends E> i1, Iterable<? extends E> i2) {
		this.its = (Iterator<E>[]) new Iterator[2];
		its[0] = (Iterator<E>) i1.iterator();
		its[1] = (Iterator<E>) i2.iterator();
	}

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterable elements in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterable
	 * @param i2
	 *            The second iterable
	 * @param i3
	 *            The third iterable
	 */
	@SuppressWarnings("unchecked")
	public  MultiIterator(
			Iterable<? extends E> i1, Iterable<? extends E> i2, Iterable<? extends E> i3) {
		this.its = (Iterator<E>[]) new Iterator[3];
		its[0] = (Iterator<E>) i1.iterator();
		its[1] = (Iterator<E>) i2.iterator();
		its[2] = (Iterator<E>) i3.iterator();
	}

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterable elements in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterable
	 * @param i2
	 *            The second iterable
	 * @param i3
	 *            The third iterable
	 * @param i4
	 *            The fourth iterable
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterable<? extends E> i1, Iterable<? extends E> i2,
			Iterable<? extends E> i3, Iterable<? extends E> i4) {
		this.its = (Iterator<E>[]) new Iterator[4];
		its[0] = (Iterator<E>) i1.iterator();
		its[1] = (Iterator<E>) i2.iterator();
		its[2] = (Iterator<E>) i3.iterator();
		its[3] = (Iterator<E>) i4.iterator();
	}

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterable elements in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterable
	 * @param i2
	 *            The second iterable
	 * @param i3
	 *            The third iterable
	 * @param i4
	 *            The fourth iterable
	 * @param i5
	 *            The fifth iterable
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterable<? extends E> i1, Iterable<? extends E> i2,
			Iterable<? extends E> i3, Iterable<? extends E> i4,
			Iterable<? extends E> i5) {
		this.its = (Iterator<E>[]) new Iterator[5];
		its[0] = (Iterator<E>) i1.iterator();
		its[1] = (Iterator<E>) i2.iterator();
		its[2] = (Iterator<E>) i3.iterator();
		its[3] = (Iterator<E>) i4.iterator();
		its[4] = (Iterator<E>) i5.iterator();
	}

	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterable elements in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterable
	 * @param i2
	 *            The second iterable
	 * @param i3
	 *            The third iterable
	 * @param i4
	 *            The fourth iterable
	 * @param i5
	 *            The fifth iterable
	 * @param i6
	 *            The sixth iterable
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterable<? extends E> i1, Iterable<? extends E> i2,
			Iterable<? extends E> i3, Iterable<? extends E> i4,
			Iterable<? extends E> i5, Iterable<? extends E> i6) {
		this.its = (Iterator<E>[]) new Iterator[6];
		its[0] = (Iterator<E>) i1.iterator();
		its[1] = (Iterator<E>) i2.iterator();
		its[2] = (Iterator<E>) i3.iterator();
		its[3] = (Iterator<E>) i4.iterator();
		its[4] = (Iterator<E>) i5.iterator();
		its[5] = (Iterator<E>) i6.iterator();
	}
	
	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterable elements in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterable
	 * @param i2
	 *            The second iterable
	 * @param i3
	 *            The third iterable
	 * @param i4
	 *            The fourth iterable
	 * @param i5
	 *            The fifth iterable
	 * @param i6
	 *            The sixth iterable
	 * @param i7
	 *            The seventh iterable
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterable<? extends E> i1, Iterable<? extends E> i2,
			Iterable<? extends E> i3, Iterable<? extends E> i4,
			Iterable<? extends E> i5, Iterable<? extends E> i6,
			Iterable<? extends E> i7) {
		this.its = (Iterator<E>[]) new Iterator[7];
		its[0] = (Iterator<E>) i1.iterator();
		its[1] = (Iterator<E>) i2.iterator();
		its[2] = (Iterator<E>) i3.iterator();
		its[3] = (Iterator<E>) i4.iterator();
		its[4] = (Iterator<E>) i5.iterator();
		its[5] = (Iterator<E>) i6.iterator();
		its[6] = (Iterator<E>) i7.iterator();
	}

	@Override
	public boolean hasNext() {
		if (idx >= its.length)
			return false;
		boolean hasNext;
		do {
			hasNext = its[idx].hasNext();
		} while (!hasNext && nextIt());
		return hasNext;
	}

	@Override
	public E next() {
		if (idx >= its.length)
			throw new NoSuchElementException();
		E e = null;
		do {
			if (its[idx].hasNext())
				e = its[idx].next();
		} while (e == null && nextIt());
		return e;
	}

	@Override
	public void remove() {
		if (idx >= its.length)
			throw new IllegalStateException();
		its[idx].remove();
	}

	private boolean nextIt() {
		its[idx++] = null;
		return idx < its.length;
	}
}