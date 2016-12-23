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

import it.riccardotraverso.json.JSONObject.Property;

/**
 * A {@code JSONVisitorAdapter} implements the interface {@link JSONVisitor} by
 * providing empty methods to each of its declarations. This way, just like with
 * event adapters in Java Swing, one can extend this adapter and redefine only
 * the required subset of methods for the task at hand - instead of having to
 * specify each and every method (even unused ones) declared in
 * {@link JSONVisitor}.
 */
public class JSONVisitorAdapter implements JSONVisitor {

	public JSONVisitorAdapter() { }

	@Override
	public void enterJSONArray(JSONArray<? extends JSON> arr) { }

	@Override
	public void exitJSONArray(JSONArray<? extends JSON> arr) { }

	@Override
	public void enterJSONObject(JSONObject obj) { }

	@Override
	public void exitJSONObject(JSONObject obj) { } 

	@Override
	public void visitJSONString(JSONString el) { }
	
	@Override
	public void visitJSONInteger(JSONInteger el) { }
	
	@Override
	public void visitJSONBoolean(JSONBoolean el) { }

	@Override
	public void visitJSONProperty(Property prop) { }

	
}
