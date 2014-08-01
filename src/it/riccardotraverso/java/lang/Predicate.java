package it.riccardotraverso.java.lang;

public interface Predicate<T> {

	/**
	 * Tells whether this predicate holds for the given object.
	 * 
	 * @param obj
	 * @return
	 */
	public boolean holdsFor(T obj);
	
}
