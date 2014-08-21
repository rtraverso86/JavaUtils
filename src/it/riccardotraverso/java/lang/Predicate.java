package it.riccardotraverso.java.lang;

public interface Predicate<T> {

	/**
	 * Tells whether this predicate holds for the given object.
	 * 
	 * @param obj
	 */
	public boolean holdsFor(T obj);
	
}
