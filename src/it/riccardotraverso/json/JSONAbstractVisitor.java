package it.riccardotraverso.json;

import it.riccardotraverso.json.JSONObject.Property;

public class JSONAbstractVisitor implements JSONVisitor {

	public JSONAbstractVisitor() { }

	@Override
	public void visitJSONArray(JSONArray arr) { }

	@Override
	public void visitJSONObject(JSONObject obj) { }

	@Override
	public void visitJSONString(JSONString str) { }

	@Override
	public void visitJSONProperty(Property prop) { }

}
