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
