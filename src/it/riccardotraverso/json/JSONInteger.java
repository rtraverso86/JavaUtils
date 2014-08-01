package it.riccardotraverso.json;

public class JSONInteger extends JSON {
	
	private int value;

	public JSONInteger(int value) {
		this.value = value;
	}
	

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}



	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}



	@Override
	public void accept(JSONVisitor v) {
		v.visitJSONInteger(this);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JSONInteger other = (JSONInteger) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}
	

}