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

package it.riccardotraverso.json;

import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * A JSON integer value.
 */
public class JSONInteger extends JSON {

	private int value;

	/**
	 * Creates a new integer JSON value.
	 * 
	 * @param value
	 */
	public JSONInteger(int value) {
		this.value = value;
	}

	/**
	 * Creates a new integer JSON value.
	 * 
	 * @param value
	 */
	public JSONInteger(Integer value) {
		this.value = value == null ? 0 : value.intValue();
	}

	/**
	 * Creates a new integer JSON value.
	 * 
	 * @param value
	 */
	public JSONInteger(String value) {
		this.value = value == null ? 0 : Integer.parseInt(value);
	}

	/**
	 * Creates a new integer JSON value.
	 * 
	 * @param value
	 *            the boolean value to be converted to JSON integer, where true
	 *            is 1 and false is 0.
	 */
	public JSONInteger(boolean value) {
		this.value = value ? 1 : 0;
	}

	/**
	 * Returns the integer value being represented.
	 * 
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Sets the integer value being represented.
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Adds {@code a} to the current value being represented.
	 * 
	 * @param a
	 *            the increment
	 */
	public void add(int a) {
		this.value += a;
	}

	/**
	 * Subtracts {@code a} from the current value being represented.
	 * 
	 * @param a
	 *            the decrement
	 */
	public void sub(int a) {
		this.value -= a;
	}

	@Override
	public void accept(JSONVisitor v) {
		v.visitJSONInteger(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JSONInteger other = (JSONInteger) obj;
		if (value != other.value)
			return false;
		return true;
	}

}
