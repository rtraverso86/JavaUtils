package it.riccardotraverso.json;

import it.riccardotraverso.java.lang.StringUtils;

import java.util.Iterator;
import java.util.LinkedList;

public class JSONObject extends JSON implements Iterable<JSONObject.Property> {

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
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the value
		 */
		public JSON getValue() {
			return value;
		}

		/**
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

		@Override
		public String toString() {
			return "\"" + name + "\" : " + value.toString();
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
		v.visitJSONObject(this);
		for (Property property : properties) {
			property.accept(v);
		}
	}

	@Override
	public Iterator<Property> iterator() {
		return properties.iterator();
	}

	@Override
	public String toString() {
		boolean removeTrailing = false;
		StringBuilder builder = new StringBuilder();
		builder.append("{\n");
		increaseIndent();
		for (Property property : properties) {
			property.value.indent = this.indent;
			appendIndented(builder, property.toString());
			builder.append(",\n");
			removeTrailing = true;
		}
		if (removeTrailing) {
			builder.setLength(builder.length() - 2);
			builder.append('\n');
		}
		decreaseIndent();
		appendIndented(builder, "}");
		return builder.toString();
	}
}
