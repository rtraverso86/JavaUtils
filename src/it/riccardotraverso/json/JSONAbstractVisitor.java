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

public class JSONAbstractVisitor implements JSONVisitor {

	public JSONAbstractVisitor() { }

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
