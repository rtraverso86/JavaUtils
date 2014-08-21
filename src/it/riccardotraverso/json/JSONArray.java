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
