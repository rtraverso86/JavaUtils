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
 * A visitor can be accepted by a JSON in order to perform computations
 * involving all of the elements contained in the JSON. The execution must start
 * by passing an instance of the visitor to the {@link JSON#accept(JSONVisitor)}
 * method of the JSON that must be traversed.
 * 
 * @see JSON
 * @see JSON#accept(JSONVisitor)
 * @see JSONVisitorAdapter
 * 
 */
public interface JSONVisitor {

	/**
	 * Method called by {@link JSON#accept(JSONVisitor)} at the beginning of the
	 * visit of a {@link JSONArray}, i.e. before propagating the visit on every
	 * item in the array.
	 * 
	 * @param arr
	 *            the {@link JSONArray} that is being currently visited
	 */
	void enterJSONArray(JSONArray<? extends JSON> arr);

	/**
	 * Method called by {@link JSON#accept(JSONVisitor)} at the end of the visit
	 * of a {@link JSONArray}, i.e. after propagating the visit on every item in
	 * the array.
	 * 
	 * @param arr
	 *            the {@link JSONArray} that is being currently visited
	 */
	void exitJSONArray(JSONArray<? extends JSON> arr);

	/**
	 * Method called by {@link JSON#accept(JSONVisitor)} at the beginning of the
	 * visit of a {@link JSONObject}, i.e. before propagating the visit on every
	 * property of the object.
	 * 
	 * @param obj
	 *            the {@link JSONObject} that is being currently visited
	 */
	void enterJSONObject(JSONObject obj);

	/**
	 * Method called by {@link JSON#accept(JSONVisitor)} at the end of the visit
	 * of a {@link JSONObject}, i.e. after propagating the visit on every
	 * property of the object.
	 * 
	 * @param obj
	 *            the {@link JSONObject} that is being currently visited
	 */
	void exitJSONObject(JSONObject obj);

	/**
	 * Method called by {@link JSON#accept(JSONVisitor)} during the visit of a
	 * {@link JSONString}. In the recursive tree of calls to the methods of the
	 * visitor, this represents a leave.
	 * 
	 * @param JSONString
	 *            el the {@link JSONString} that is being currently visited
	 */
	void visitJSONString(JSONString el);

	/**
	 * Method called by {@link JSON#accept(JSONVisitor)} during the visit of a
	 * {@link JSONInteger}. In the recursive tree of calls to the methods of the
	 * visitor, this represents a leave.
	 * 
	 * @param el
	 *            the {@link JSONInteger} that is being currently visited
	 */
	void visitJSONInteger(JSONInteger el);

	/**
	 * Method called by {@link JSON#accept(JSONVisitor)} during the visit of a
	 * {@link JSONBoolean}. In the recursive tree of calls to the methods of the
	 * visitor, this represents a leave.
	 * 
	 * @param el
	 *            the {@link JSONBoolean} that is being currently visited
	 */
	void visitJSONBoolean(JSONBoolean el);

	/**
	 * Method called by {@link JSON#accept(JSONVisitor)} during the visit of a
	 * {@link JSONObject.Property}, before propagating it to the {@link JSON}
	 * value pointed by the property.
	 * 
	 * @param el
	 *            the {@link JSONObject.Property} that is being currently
	 *            visited
	 */
	void visitJSONProperty(JSONObject.Property prop);

}
