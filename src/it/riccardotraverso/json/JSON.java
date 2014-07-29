package it.riccardotraverso.json;

public abstract class JSON {
	

	/**
	 * Indentation, set by classes from the same package when rendering the
	 * JSON value via toString().
	 */
	String indent = "";
	static final String SINGLE_INDENT = "  "; 

	
	public abstract void accept(JSONVisitor v);
	
	
	
	void appendIndented(StringBuilder builder, Object val) {
		builder.append(indent);
		builder.append(val);
	}
	
	void increaseIndent() {
		this.indent += SINGLE_INDENT;
	}
	
	void decreaseIndent() {
		this.indent = this.indent.substring(SINGLE_INDENT.length());
	}

}
