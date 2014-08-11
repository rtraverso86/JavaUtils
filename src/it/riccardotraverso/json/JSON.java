package it.riccardotraverso.json;

public abstract class JSON {
	
	public abstract void accept(JSONVisitor v);
	
	@Override
	public String toString() {
		JSONPrettyPrint pp = new JSONPrettyPrint();
		this.accept(pp);
		return pp.prettyPrint();
	}
	
	public static void main(String[] args) {
		JSONArray<JSON> js = new JSONArray<JSON>();
		JSONObject obj = new JSONObject();
		obj.setProperty("hello", new JSONString("world"));
		obj.setProperty("name", new JSONBoolean(false));
		js.addValue(obj);
		js.addValue(new JSONInteger(2454));
		JSONObject obj2 = new JSONObject();
		obj2.setProperty("b", new JSONString("c"));
		obj = new JSONObject();
		obj.setProperty("1", js);
		obj.setProperty("2", obj2);
		obj.setProperty("3", new JSONObject());
		obj.setProperty("4", new JSONArray<JSON>());
		System.out.println(obj.toString());
	}

}
