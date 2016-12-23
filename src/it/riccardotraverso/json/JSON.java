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

/**
 * A generic JSON element (see the Composite design pattern) built in Java 
 * as a tree structure made from subclasses of this root class.
 * 
 * It provides support for {@link JSONVisitor} (see the Visitor design pattern)
 * as a mean to perform visits and computations that are propagated on every JSON element
 * contained, from the root to the leaves. See {@link JSONPrettyPrint} together with
 * {@link #toString()} for a complete example.
 * 
 * @see JSONVisitor
 * @see JSONVisitorAdapter
 */
public abstract class JSON {
	
	/**
	 * Accepting a visitor object means recursively calling the proper visitor's
	 * methods on all of the JSON objects contained.
	 * 
	 * @param v
	 *            the visitor to be accepted by the current JSON element
	 *            
	 * @see JSONVisitor
	 */
	public abstract void accept(JSONVisitor v);
	
	/**
	 * Pretty-prints the current element as a valid JSON string.
	 */
	@Override
	public String toString() {
		JSONPrettyPrint pp = new JSONPrettyPrint();
		this.accept(pp);
		return pp.prettyPrint();
	}

}
