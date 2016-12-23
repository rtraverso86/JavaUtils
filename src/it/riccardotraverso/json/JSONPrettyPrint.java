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

import it.riccardotraverso.java.util.ArraysUtils;
import it.riccardotraverso.json.JSONObject.Property;

/**
 * Converts a {@link JSON} into a human-readable formatted JSON string. It is
 * not suggested to use directly this class, but rather to rely on the simpler
 * {@link JSON#toString()} method.
 * 
 * @see JSON#toString()
 */
public class JSONPrettyPrint extends JSONVisitorAdapter {
	
	private StringBuilder sb = new StringBuilder();
	private int indent = 0;
	private char tab;

	public JSONPrettyPrint() { this('\t'); }
	
	public JSONPrettyPrint(char tab) { this.tab = tab; }
	
	
	@Override
	public void visitJSONString(JSONString el) {
		sb.append('"');
		sb.append(el.getText());
		sb.append('"');
		newLine();
	}
	
	@Override
	public void visitJSONBoolean(JSONBoolean el) {
		sb.append(Boolean.toString(el.getValue()));
		newLine();
	}

	@Override
	public void visitJSONInteger(JSONInteger el) {
		sb.append(Integer.toString(el.getValue()));
		newLine();
	}

	@Override
	public void enterJSONArray(JSONArray<? extends JSON> arr) {
		sb.append("[\n");
		indent++;
		addSpacing();
	}
	
	@Override
	public void exitJSONArray(JSONArray<? extends JSON> arr) {
		exitBlock();
		sb.append("]");
		newLine();
	}

	
	@Override
	public void enterJSONObject(JSONObject obj) {
		indent++;
		sb.append("{\n");
		addSpacing();
	}
	
	@Override
	public void visitJSONProperty(Property prop) {
		sb.append('"');
		sb.append(prop.getName());
		sb.append("\" : ");
	}
	
	@Override
	public void exitJSONObject(JSONObject obj) {
		exitBlock();
		sb.append("}");
		newLine();
	}
	
	/**
	 * Returns the visited JSON object as formatted code.
	 */
	public String prettyPrint() {
		return sb.toString();
	}
	
	private void addSpacing() {
		sb.append(ArraysUtils.replicate(indent, tab));
	}
	
	private void newLine() {
		if (indent > 0) {
			sb.append(",\n");
			addSpacing();
		}
	}
	
	private void exitBlock() {
		int limit = sb.length() - 2 - indent;
		if (sb.charAt(limit) == ',') {
			sb.setLength(limit);
			sb.append('\n');
			indent--;
			addSpacing();
		} else if (indent > 0) {
			indent--;
			sb.setLength(limit+1);
		}
	}

}
