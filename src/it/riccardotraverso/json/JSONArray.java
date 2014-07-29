package it.riccardotraverso.json;

import java.util.ArrayList;
import java.util.Iterator;

public class JSONArray extends JSON implements Iterable<JSON> {
	
	/** The ordered list of values of the array */
	private ArrayList<JSON> values = new ArrayList<JSON>();

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
	public void addValue(JSON value) {
		values.add(value);
	}
	
	/**
	 * Removes a specified value from the array (by reference).
	 * 
	 * @param value
	 */
	public void removeValue(JSON value) {
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
	 * @return
	 */
	public JSON getValue(int index) {
		return values.get(index);
	}
	
	/**
	 * Returns the number of elements in the array.
	 * 
	 * @return
	 */
	public int size() {
		return values.size();
	}

	@Override
	public Iterator<JSON> iterator() {
		return values.iterator();
	}
	
	@Override
	public void accept(JSONVisitor v) {
		v.visitJSONArray(this);
		for (JSON value : values) {
			value.accept(v);
		}
	}
	
	@Override
	public String toString() {
		boolean removeTrailing = false;
		StringBuilder builder = new StringBuilder();
		builder.append("[\n");
		increaseIndent();
		for (JSON value : values) {
			value.indent = this.indent;
			appendIndented(builder, value.toString());
			builder.append(",\n");
			removeTrailing = true;
		}
		decreaseIndent();
		if (removeTrailing) {
			builder.setLength(builder.length() - 2);
			builder.append('\n');
		}
		appendIndented(builder, "]");
		return builder.toString();
	}

}