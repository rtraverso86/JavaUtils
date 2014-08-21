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

package it.riccardotraverso.xml;

import java.util.HashMap;
import java.util.Map;

public class XmlTagOptions {
	
	private Map<String, String> options = new HashMap<String, String>();

	public XmlTagOptions() { }
	
	/** Sets a value for an option, eventually overwriting the old one.
	 * 
	 * @param option
	 * @param value
	 */
	public void set(String option, String value) {
		options.put(option, value);
	}
	
	/**
	 * Clears the current set of options
	 */
	public void clear() {
		options.clear();
	}
	
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
