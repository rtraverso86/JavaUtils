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

package it.riccardotraverso.xml;

import java.util.HashMap;
import java.util.Map;

/**
 * This class makes building strings of attributes for XML tags in the
 * {@link XmlStringBuilder} easier.
 * 
 * @see XmlStringBuilder
 * @see XmlStringBuilder#openTag(String, String)
 * @see XmlStringBuilder#tag(String, String)
 * @see XmlStringBuilder#tagWithText(String, String, String)
 * 
 */
public class XmlTagOptions {

	private Map<String, String> options = new HashMap<String, String>();

	/**
	 * Creates a new, empty <code>XmlTagOptions</code>.
	 */
	public XmlTagOptions() {
	}

	/**
	 * Sets a value for an option, eventually overwriting the old one if already
	 * set.
	 * 
	 * @param attribute
	 *            the name of the attributes
	 * @param value
	 *            the value to be associated to the attribute
	 */
	public void set(String attribute, String value) {
		options.put(attribute, value);
	}

	/**
	 * Clears the current set of options.
	 */
	public void clear() {
		options.clear();
	}

	/**
	 * Converts to a string the current set of options. The result can be used
	 * for every attributes string taken in input by the methods of
	 * {@link XmlStringBuilder}.
	 * 
	 * @see XmlStringBuilder#openTag(String, String)
	 * @see XmlStringBuilder#tag(String, String)
	 * @see XmlStringBuilder#tagWithText(String, String, String)
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> opt : options.entrySet()) {
			sb.append(opt.getKey());
			sb.append("=\"");
			sb.append(opt.getValue());
			sb.append("\" ");
		}
		return sb.toString();
	}

}
