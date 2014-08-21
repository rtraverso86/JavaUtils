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

public class JSONBoolean extends JSON {

	private boolean value;

	/**
	 * @param value
	 */
	public JSONBoolean(boolean value) {
		super();
		this.value = value;
	}
	
	public JSONBoolean(Boolean value) {
		this.value = value.booleanValue();
	}
	
	public JSONBoolean(String value) {
		this.value = Boolean.parseBoolean(value);
	}
	
	public JSONBoolean(int value) {
		this.value = value == 0 ? false : true;
	}

	/**
	 * @return the value
	 */
	public boolean getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(boolean value) {
		this.value = value;
	}

	/**
	 * Same as getValue().
	 */
	public boolean isTrue() {
		return value;
	}

	public boolean isFalse() {
		return !value;
	}

	public void toggle() {
		value = !value;
	}

	@Override
	public void accept(JSONVisitor v) {
		v.visitJSONBoolean(this);
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
		result = prime * result + (value ? 1231 : 1237);
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
		JSONBoolean other = (JSONBoolean) obj;
		if (value != other.value)
			return false;
		return true;
	}

}
