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
	 *            The first iterator, of type
	 *            <code>Iterator&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterator, of type
	 *            <code>Iterator&lt;E2 extends E&gt;</code>.
	 */
	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E> MultiIterator(Iterator<E1> i1,
			Iterator<E2> i2) {
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
	 * @param i1
	 *            The first iterator, of type
	 *            <code>Iterator&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterator, of type
	 *            <code>Iterator&lt;E2 extends E&gt;</code>.
	 * @param i3
	 *            The third iterator, of type
	 *            <code>Iterator&lt;E3 extends E&gt;</code>.
	 */
	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E> MultiIterator(
			Iterator<E1> i1, Iterator<E2> i2, Iterator<E3> i3) {
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
	 *            The first iterator, of type
	 *            <code>Iterator&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterator, of type
	 *            <code>Iterator&lt;E2 extends E&gt;</code>.
	 * @param i3
	 *            The third iterator, of type
	 *            <code>Iterator&lt;E3 extends E&gt;</code>.
	 * @param i4
	 *            The fourth iterator, of type
	 *            <code>Iterator&lt;E4 extends E&gt;</code>.
	 */
	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E> MultiIterator(
			Iterator<E1> i1, Iterator<E2> i2, Iterator<E3> i3, Iterator<E4> i4) {
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
	 *            The first iterator, of type
	 *            <code>Iterator&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterator, of type
	 *            <code>Iterator&lt;E2 extends E&gt;</code>.
	 * @param i3
	 *            The third iterator, of type
	 *            <code>Iterator&lt;E3 extends E&gt;</code>.
	 * @param i4
	 *            The fourth iterator, of type
	 *            <code>Iterator&lt;E4 extends E&gt;</code>.
	 * @param i5
	 *            The fifth iterator, of type
	 *            <code>Iterator&lt;E5 extends E&gt;</code>.
	 */
	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E, E5 extends E> MultiIterator(
			Iterator<E1> i1, Iterator<E2> i2, Iterator<E3> i3, Iterator<E4> i4,
			Iterator<E5> i5) {
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
	 *            The first iterator, of type
	 *            <code>Iterator&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterator, of type
	 *            <code>Iterator&lt;E2 extends E&gt;</code>.
	 * @param i3
	 *            The third iterator, of type
	 *            <code>Iterator&lt;E3 extends E&gt;</code>.
	 * @param i4
	 *            The fourth iterator, of type
	 *            <code>Iterator&lt;E4 extends E&gt;</code>.
	 * @param i5
	 *            The fifth iterator, of type
	 *            <code>Iterator&lt;E5 extends E&gt;</code>.
	 * @param i6
	 *            The sixth iterator, of type
	 *            <code>Iterator&lt;E6 extends E&gt;</code>.
	 */
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
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterators in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterator, of type
	 *            <code>Iterator&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterator, of type
	 *            <code>Iterator&lt;E2 extends E&gt;</code>.
	 * @param i3
	 *            The third iterator, of type
	 *            <code>Iterator&lt;E3 extends E&gt;</code>.
	 * @param i4
	 *            The fourth iterator, of type
	 *            <code>Iterator&lt;E4 extends E&gt;</code>.
	 * @param i5
	 *            The fifth iterator, of type
	 *            <code>Iterator&lt;E5 extends E&gt;</code>.
	 * @param i6
	 *            The sixth iterator, of type
	 *            <code>Iterator&lt;E6 extends E&gt;</code>.
	 * @param i7
	 *            The seventh iterator, of type
	 *            <code>Iterator&lt;E7 extends E&gt;</code>.
	 */
	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E, E5 extends E, E6 extends E, E7 extends E> MultiIterator(
			Iterator<E1> i1, Iterator<E2> i2, Iterator<E3> i3, Iterator<E4> i4,
			Iterator<E5> i5, Iterator<E6> i6, Iterator<E7> i7) {
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
	 *            The first iterable, of type
	 *            <code>Iterable&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterable, of type
	 *            <code>Iterable&lt;E2 extends E&gt;</code>.
	 */
	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E> MultiIterator(
			Iterable<E1> i1, Iterable<E2> i2) {
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
	 *            The first iterable, of type
	 *            <code>Iterable&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterable, of type
	 *            <code>Iterable&lt;E2 extends E&gt;</code>.
	 * @param i3
	 *            The third iterable, of type
	 *            <code>Iterable&lt;E3 extends E&gt;</code>.
	 */
	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E> MultiIterator(
			Iterable<E1> i1, Iterable<E2> i2, Iterable<E3> i3) {
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
	 *            The first iterable, of type
	 *            <code>Iterable&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterable, of type
	 *            <code>Iterable&lt;E2 extends E&gt;</code>.
	 * @param i3
	 *            The third iterable, of type
	 *            <code>Iterable&lt;E3 extends E&gt;</code>.
	 * @param i4
	 *            The fourth iterable, of type
	 *            <code>Iterable&lt;E4 extends E&gt;</code>.
	 */
	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E> MultiIterator(
			Iterable<E1> i1, Iterable<E2> i2, Iterable<E3> i3, Iterable<E4> i4) {
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
	 *            The first iterable, of type
	 *            <code>Iterable&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterable, of type
	 *            <code>Iterable&lt;E2 extends E&gt;</code>.
	 * @param i3
	 *            The third iterable, of type
	 *            <code>Iterable&lt;E3 extends E&gt;</code>.
	 * @param i4
	 *            The fourth iterable, of type
	 *            <code>Iterable&lt;E4 extends E&gt;</code>.
	 * @param i5
	 *            The fifth iterable, of type
	 *            <code>Iterable&lt;E5 extends E&gt;</code>.
	 */
	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E, E5 extends E> MultiIterator(
			Iterable<E1> i1, Iterable<E2> i2, Iterable<E3> i3, Iterable<E4> i4,
			Iterable<E5> i5) {
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
	 *            The first iterable, of type
	 *            <code>Iterable&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterable, of type
	 *            <code>Iterable&lt;E2 extends E&gt;</code>.
	 * @param i3
	 *            The third iterable, of type
	 *            <code>Iterable&lt;E3 extends E&gt;</code>.
	 * @param i4
	 *            The fourth iterable, of type
	 *            <code>Iterable&lt;E4 extends E&gt;</code>.
	 * @param i5
	 *            The fifth iterable, of type
	 *            <code>Iterable&lt;E5 extends E&gt;</code>.
	 * @param i6
	 *            The sixth iterable, of type
	 *            <code>Iterable&lt;E6 extends E&gt;</code>.
	 */
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
	
	/**
	 * Creates a new <code>MultiIterator&lt;E&gt;</code> by taking in individual
	 * iterable elements in a sequence, such that each one is instantiated on a
	 * (possibly different) type parameter which is a subclass of <code>E</code>
	 * .
	 * 
	 * @param i1
	 *            The first iterable, of type
	 *            <code>Iterable&lt;E1 extends E&gt;</code>.
	 * @param i2
	 *            The second iterable, of type
	 *            <code>Iterable&lt;E2 extends E&gt;</code>.
	 * @param i3
	 *            The third iterable, of type
	 *            <code>Iterable&lt;E3 extends E&gt;</code>.
	 * @param i4
	 *            The fourth iterable, of type
	 *            <code>Iterable&lt;E4 extends E&gt;</code>.
	 * @param i5
	 *            The fifth iterable, of type
	 *            <code>Iterable&lt;E5 extends E&gt;</code>.
	 * @param i6
	 *            The sixth iterable, of type
	 *            <code>Iterable&lt;E6 extends E&gt;</code>.
	 * @param i7
	 *            The seventh iterable, of type
	 *            <code>Iterable&lt;E7 extends E&gt;</code>.
	 */
	@SuppressWarnings("unchecked")
	public <E1 extends E, E2 extends E, E3 extends E, E4 extends E, E5 extends E, E6 extends E, E7 extends E> MultiIterator(
			Iterable<E1> i1, Iterable<E2> i2, Iterable<E3> i3, Iterable<E4> i4,
			Iterable<E5> i5, Iterable<E6> i6, Iterable<E7> i7) {
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