package it.riccardotraverso.json;

public interface JSONVisitor {
	
	void visitJSONArray(JSONArray<? extends JSON> arr);
	
	void visitJSONObject(JSONObject obj);
	
	void visitJSONString(JSONString el);
	
	void visitJSONInteger(JSONInteger el);
	
	void visitJSONBoolean(JSONBoolean el);
	
	void visitJSONProperty(JSONObject.Property prop);

}
