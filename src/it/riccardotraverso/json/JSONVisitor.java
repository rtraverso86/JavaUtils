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
