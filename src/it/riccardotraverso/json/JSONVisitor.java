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

public interface JSONVisitor {
	
	void enterJSONArray(JSONArray<? extends JSON> arr);
	void exitJSONArray(JSONArray<? extends JSON> arr);
	
	void enterJSONObject(JSONObject obj);
	void exitJSONObject(JSONObject obj);
	
	void visitJSONString(JSONString el);
	
	void visitJSONInteger(JSONInteger el);
	
	void visitJSONBoolean(JSONBoolean el);
	
	void visitJSONProperty(JSONObject.Property prop);

}
