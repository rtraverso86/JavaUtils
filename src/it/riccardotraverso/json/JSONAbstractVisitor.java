package it.riccardotraverso.json;

import it.riccardotraverso.json.JSONObject.Property;

public class JSONAbstractVisitor implements JSONVisitor {

	public JSONAbstractVisitor() { }

	@Override
	public void visitJSONArray(JSONArray<? extends JSON> arr) { }

	@Override
	public void visitJSONObject(JSONObject obj) { }

	@Override
	public void visitJSONString(JSONString el) { }
	
	@Override
	public void visitJSONInteger(JSONInteger el) { }

	@Override
	public void visitJSONProperty(Property prop) { }
	
}
