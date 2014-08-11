package it.riccardotraverso.json;

import it.riccardotraverso.java.util.ArraysUtils;
import it.riccardotraverso.json.JSONObject.Property;

public class JSONPrettyPrint extends JSONAbstractVisitor {
	
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
	 *  
	 * @return
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
			sb.setLength(limit);
		}
	}

}
