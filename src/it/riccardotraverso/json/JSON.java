package it.riccardotraverso.json;

public abstract class JSON {
	
	public abstract void accept(JSONVisitor v);
	
	@Override
	public String toString() {
		JSONPrettyPrint pp = new JSONPrettyPrint();
		this.accept(pp);
		return pp.prettyPrint();
	}

}
