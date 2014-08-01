package it.riccardotraverso.json;

public interface JSONVisitor {
	
	void visitJSONArray(JSONArray<? extends JSON> arr);
	
	void visitJSONObject(JSONObject obj);
	
	void visitJSONString(JSONString str);
	
	void visitJSONProperty(JSONObject.Property prop);

}
