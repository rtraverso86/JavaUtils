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

import it.riccardotraverso.java.lang.StringUtils;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A JSON object is a sort of dictionary associating labels to other JSON
 * elements via {@link JSONObject.Property}.
 * 
 */
public class JSONObject extends JSON implements Iterable<JSONObject.Property> {

	/**
	 * An entry of a {@link JSONObject}, composed of a property name and a
	 * respective {@link JSON} value.
	 */
	public class Property {
		private String name;
		private JSON value;

		/**
		 * Creates a new Property for a JSONObject.
		 * 
		 * @param name
		 * @param value
		 */
		public Property(String name, JSON value) {
			super();
			if (StringUtils.isBlank(name))
				throw new IllegalArgumentException(
						"name cannot be null or empty");
			if (value == null)
				throw new IllegalArgumentException("value cannot be null");
			this.name = name;
			this.value = value;
		}

		/**
		 * Returns the name of the property.
		 * 
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * Sets the name of the property.
		 * 
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Returns the value of the property.
		 * 
		 * @return the value
		 */
		public JSON getValue() {
			return value;
		}

		/**
		 * Sets the value of the property.
		 * 
		 * @param value
		 *            the value to set
		 */
		public void setValue(JSON value) {
			this.value = value;
		}
		
		public void accept(JSONVisitor v) {
			v.visitJSONProperty(this);
			value.accept(v);
		}

	}

	/** The ordered list of properties of the object */
	private LinkedList<JSONObject.Property> properties = new LinkedList<JSONObject.Property>();

	/**
	 * Creates a new, empty JSONObject.
	 */
	public JSONObject() {
	}

	/**
	 * Sets the value of a given property, eventually creating it when not
	 * present.
	 * 
	 * @param name
	 * @param value
	 * @return a pointer to this, to chain more quickly multiple calls to
	 *         setProperty().
	 */
	public JSONObject setProperty(String name, JSON value) {
		Property property = getProperty(name);
		if (property == null) {
			properties.add(new Property(name, value));
		} else {
			property.value = value;
		}
		return this;
	}

	/**
	 * Removes a property from the object given its name.
	 * 
	 * @param name
	 * @return true iff the property was present and correctly removed
	 */
	public boolean removeProperty(String name) {
		Property property = getProperty(name);
		if (property != null) {
			return properties.remove(property);
		}
		return false;
	}

	/**
	 * Returns a property given its name.
	 * 
	 * @param name
	 * @return the property if present, null otherwise
	 */
	public JSONObject.Property getProperty(String name) {
		for (Property property : properties) {
			if (property.name.equals(name)) {
				return property;
			}
		}
		return null;
	}

	/**
	 * Returns the value associated to a given property.
	 * 
	 * @param propertyName
	 * @return the corresponding value, or null if the property is not present
	 */
	public JSON getPropertyValue(String propertyName) {
		Property property = getProperty(propertyName);
		if (property != null) {
			return property.value;
		}
		return null;
	}

	@Override
	public void accept(JSONVisitor v) {
		v.enterJSONObject(this);
		for (Property property : properties) {
			property.accept(v);
		}
		v.exitJSONObject(this);
	}

	@Override
	public Iterator<Property> iterator() {
		return properties.iterator();
	}

}
