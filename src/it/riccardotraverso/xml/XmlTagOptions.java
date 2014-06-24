package it.riccardotraverso.xml;

import java.util.HashMap;
import java.util.Map;

public class XmlTagOptions {
	
	private Map<String, String> options = new HashMap<>();

	public XmlTagOptions() { }
	
	/** Sets a value for an option, eventually overwriting the old one.
	 * 
	 * @param option
	 * @param value
	 */
	public void set(String option, String value) {
		options.put(option, value);
	}
	
	/**
	 * Clears the current set of options
	 */
	public void clear() {
		options.clear();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> opt : options.entrySet()) {
			sb.append(opt.getKey());
			sb.append("=\"");
			sb.append(opt.getValue());
			sb.append("\" ");
		}
		return sb.toString();
	}

}
