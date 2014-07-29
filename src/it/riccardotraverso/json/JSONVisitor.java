package it.riccardotraverso.json;

public interface JSONVisitor {
	
	void visitJSONArray(JSONArray arr);
	
	void visitJSONObject(JSONObject obj);
	
	void visitJSONString(JSONString str);
	
	void visitJSONProperty(JSONObject.Property prop);

}
