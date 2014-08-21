package it.riccardotraverso.json;

import it.riccardotraverso.java.lang.Predicate;

import java.util.ArrayList;
import java.util.Iterator;

public class JSONArray<J extends JSON> extends JSON implements Iterable<J> {
	
	/** The ordered list of values of the array */
	private ArrayList<J> values = new ArrayList<J>();

	/**
	 * Creates a new empty JSONArray.
	 */
	public JSONArray() {
	}
	
	/**
	 * Adds a new value to the array.
	 * 
	 * @param value
	 */
	public void addValue(J value) {
		values.add(value);
	}
	
	/**
	 * Removes a specified value from the array (by reference).
	 * 
	 * @param value
	 */
	public void removeValue(J value) {
		values.remove(value);
	}
	
	
	/**
	 * Removes an element at a given index.
	 * 
	 * @param index
	 */
	public void removeValue(int index) {
		values.remove(index);
	}
	
	/**
	 * Returns an element at a given index. 
	 * @param index
	 */
	public JSON getValue(int index) {
		return values.get(index);
	}
	
	/**
	 * Returns the number of elements in the array.
	 * 
	 */
	public int size() {
		return values.size();
	}

	/**
	 * Finds and returns the first JSON element in the array which satisfies the
	 * given predicate.
	 * 
	 * @param pred
	 * @return the first element satisfying pred in the array, or null if any
	 */
	public J find(Predicate<J> pred) {
		for (J value : values) {
			if (pred.holdsFor(value)) {
				return value;
			}
		}
		return null;
	}

	@Override
	public Iterator<J> iterator() {
		return values.iterator();
	}
	
	@Override
	public void accept(JSONVisitor v) {
		v.enterJSONArray(this);
		for (J value : values) {
			value.accept(v);
		}
		v.exitJSONArray(this);
	}
		
}
