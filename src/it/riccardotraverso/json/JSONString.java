package it.riccardotraverso.json;

public class JSONString extends JSON {
	
	private String value;

	public JSONString(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public void accept(JSONVisitor v) {
		v.visitJSONString(this);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('"');
		builder.append(value);
		builder.append('"');
		return builder.toString();
	}

}
