package it.riccardotraverso.java.lang;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterates over the elements of a list of iterators.
 * 
 * @param <E>
 */
public class MultiIterator<E> implements Iterator<E> {
	private Iterator<E> its[];
	private int idx = 0;

	/**
	 * 
	 * @param its
	 *            the iterators
	 */
	public MultiIterator(Iterator<E>... its) {
		super();
		if (its.length < 2)
			throw new IllegalArgumentException(
					"at least two iterators are required");
		this.its = its;
	}

	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E> MultiIterator(Iterator<E1> i1,
			Iterator<E2> i2) {
		this.its = (Iterator<E>[]) new Iterator[2];
		its[0] = (Iterator<E>) i1;
		its[1] = (Iterator<E>) i2;
	}

	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E> MultiIterator(
			Iterator<E1> i1, Iterator<E2> i2, Iterator<E3> i3) {
		this.its = (Iterator<E>[]) new Iterator[6];
		its[0] = (Iterator<E>) i1;
		its[1] = (Iterator<E>) i2;
		its[2] = (Iterator<E>) i3;
	}

	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E> MultiIterator(
			Iterator<E1> i1, Iterator<E2> i2, Iterator<E3> i3, Iterator<E4> i4) {
		this.its = (Iterator<E>[]) new Iterator[6];
		its[0] = (Iterator<E>) i1;
		its[1] = (Iterator<E>) i2;
		its[2] = (Iterator<E>) i3;
		its[3] = (Iterator<E>) i4;
	}

	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E, E5 extends E> MultiIterator(
			Iterator<E1> i1, Iterator<E2> i2, Iterator<E3> i3, Iterator<E4> i4,
			Iterator<E5> i5) {
		this.its = (Iterator<E>[]) new Iterator[6];
		its[0] = (Iterator<E>) i1;
		its[1] = (Iterator<E>) i2;
		its[2] = (Iterator<E>) i3;
		its[3] = (Iterator<E>) i4;
		its[4] = (Iterator<E>) i5;
	}

	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E, E5 extends E, E6 extends E> MultiIterator(
			Iterator<E1> i1, Iterator<E2> i2, Iterator<E3> i3, Iterator<E4> i4,
			Iterator<E5> i5, Iterator<E6> i6) {
		this.its = (Iterator<E>[]) new Iterator[6];
		its[0] = (Iterator<E>) i1;
		its[1] = (Iterator<E>) i2;
		its[2] = (Iterator<E>) i3;
		its[3] = (Iterator<E>) i4;
		its[4] = (Iterator<E>) i5;
		its[5] = (Iterator<E>) i6;
	}

	/**
	 * 
	 * @param its
	 *            the iterators
	 */
	@SuppressWarnings("unchecked")
	public MultiIterator(Iterable<E>... its) {
		super();
		if (its.length < 2)
			throw new IllegalArgumentException(
					"at least two iterators are required");
		this.its = (Iterator<E>[]) new Iterator[its.length];
		for (int i = 0; i < its.length; i++) {
			this.its[i] = its[i].iterator();
		}
	}

	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E> MultiIterator(
			Iterable<E1> i1, Iterable<E2> i2) {
		this.its = (Iterator<E>[]) new Iterator[6];
		its[0] = (Iterator<E>) i1.iterator();
		its[1] = (Iterator<E>) i2.iterator();
	}

	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E> MultiIterator(
			Iterable<E1> i1, Iterable<E2> i2, Iterable<E3> i3) {
		this.its = (Iterator<E>[]) new Iterator[6];
		its[0] = (Iterator<E>) i1.iterator();
		its[1] = (Iterator<E>) i2.iterator();
		its[2] = (Iterator<E>) i3.iterator();
	}

	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E> MultiIterator(
			Iterable<E1> i1, Iterable<E2> i2, Iterable<E3> i3, Iterable<E4> i4) {
		this.its = (Iterator<E>[]) new Iterator[6];
		its[0] = (Iterator<E>) i1.iterator();
		its[1] = (Iterator<E>) i2.iterator();
		its[2] = (Iterator<E>) i3.iterator();
		its[3] = (Iterator<E>) i4.iterator();
	}

	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E, E5 extends E> MultiIterator(
			Iterable<E1> i1, Iterable<E2> i2, Iterable<E3> i3, Iterable<E4> i4,
			Iterable<E5> i5) {
		this.its = (Iterator<E>[]) new Iterator[6];
		its[0] = (Iterator<E>) i1.iterator();
		its[1] = (Iterator<E>) i2.iterator();
		its[2] = (Iterator<E>) i3.iterator();
		its[3] = (Iterator<E>) i4.iterator();
		its[4] = (Iterator<E>) i5.iterator();
	}

	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E, E5 extends E, E6 extends E> MultiIterator(
			Iterable<E1> i1, Iterable<E2> i2, Iterable<E3> i3, Iterable<E4> i4,
			Iterable<E5> i5, Iterable<E6> i6) {
		this.its = (Iterator<E>[]) new Iterator[6];
		its[0] = (Iterator<E>) i1.iterator();
		its[1] = (Iterator<E>) i2.iterator();
		its[2] = (Iterator<E>) i3.iterator();
		its[3] = (Iterator<E>) i4.iterator();
		its[4] = (Iterator<E>) i5.iterator();
		its[5] = (Iterator<E>) i6.iterator();
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