package it.riccardotraverso.xml;

import it.riccardotraverso.java.lang.StringUtils;
import it.riccardotraverso.java.util.ArraysUtils;

import java.util.Stack;

public class XmlStringBuilder {
	
	
	
	private StringBuilder _sb = new StringBuilder();
	private Stack<String> _tags = new Stack<String>();
	private boolean _isClosed = false;
	
	/** Character used for indentation */
	protected static char TABS = ' ';
	
	private static final String CLOSED_ERROR = "XML document is already closed";
	

	
	public XmlStringBuilder() {
		initXml();
	}
	
	public XmlStringBuilder(int defaultNestingSize) {
		initXml();
		_tags.ensureCapacity(defaultNestingSize);
	}

	
	
	/**
	 * Adds a self-contained tag <code>&lt;tag options\&gt;text&lt;/tag&gt;</code>.
	 * @param tag
	 * @param options
	 * @param text
	 */
	public void tagWithText(String tag, String options, String text) {
		if (_isClosed)
			throw new RuntimeException(CLOSED_ERROR);
		initTag(tag, options, false);
		_sb.append('>');
		_sb.append(text);
		_sb.append("</");
		_sb.append(tag);
		_sb.append('>');
	}
	
	/**
	 * Adds a self-contained tag <code>&lt;tag\&gt;text&lt;/tag&gt;</code>.
	 * @param tag
	 * @param text
	 */
	public void tagWithText(String tag, String text) {
		tagWithText(tag, null, text);
	}
	
	/**
	 * Adds a self contained tag <code>&lt;tag options /&gt;</code>.
	 * 
	 * @param tag
	 * @param options
	 */
	public void tag(String tag, String options) {
		if (_isClosed)
			throw new RuntimeException(CLOSED_ERROR);
		initTag(tag, options, false);
		_sb.append("/>");
	}
	
	/**
	 * Adds a self contained tag <code>&lt;tag/&gt;</code>.
	 * 
	 * @param t
	 */
	public void tag(String t) {
		tag(t, null);
	}
	
	/**
	 * Opens a new tag </code>&lt;tag options></code>.
	 * 
	 * @param t
	 * @param options
	 */
	public void openTag(String t, String options) {
		if (_isClosed)
			throw new RuntimeException(CLOSED_ERROR);
		initTag(t, options, true);
		_sb.append(">");
	}
	
	/**
	 * Opens a new tag </code>&lt;tag></code>.
	 * 
	 * @param t
	 */
	public void openTag(String t) {
		tag(t, null);
	}
	
	/**
	 * Appends a simple string of text.
	 *  
	 * @param txt
	 */
	public void text(String txt) {
		if (_isClosed)
			throw new RuntimeException(CLOSED_ERROR);
		_sb.append('\n');
		addSpacing();
		_sb.append(txt);
	}

	/**
	 * Closes the last tag opened, if any.
	 * 
	 */
	public void closeTag() {
		if (_isClosed)
			throw new RuntimeException(CLOSED_ERROR);
		String tag = _tags.pop();
		_sb.append('\n');
		addSpacing();
		_sb.append("</");
		_sb.append(tag);
		_sb.append(">");
		if (_tags.isEmpty()) {
			_isClosed = true;
		}
	}
	
	/**
	 * Closes all tags and the document
	 */
	public void close() {
		if (_isClosed)
			throw new RuntimeException(CLOSED_ERROR);
		while (!_tags.isEmpty()) {
			closeTag();
		}
	}
	
	
	/**
	 * True iff all opened tags have been closed.
	 * Once closed, the document cannot be opened again.
	 * 
	 * @return
	 */
	public boolean isClosed() {
		return _isClosed;
	}
	
	
	private void initXml() {
		initXml(null);
	}
	
	private void initXml(String options) {
		_sb.append("<?xml ");
		if (StringUtils.isBlank(options)) {
			_sb.append("version=\"1.0\"");
		} else {
			_sb.append(options);
		}
		_sb.append("?>");
	}
	
	/**
	 * Starts writing a new tag with options without closing
	 * it (leaves out trailing "/>" or ">").
	 *   
	 * @param tag
	 * @param options
	 * @param shouldPush true iff the tag should be pushed to the stack of opened ones
	 * 
	 * @see XmlStringBuilder#tag(String, String)
	 * @see XmlStringBuilder#openTag(String, String)
	 * 
	 */
	protected void initTag(String tag, String options, boolean shouldPush) {
		_sb.append('\n');
		addSpacing();
		if (shouldPush) {
			_tags.push(tag);
		}
		_sb.append('<');
		_sb.append(tag);
		if (!StringUtils.isBlank(options)) {
			_sb.append(' ');
			_sb.append(options);
		}
	}
	
	/**
	 * Adds the appropriate number of spacing characters for indentation
	 * purposes.
	 */
	protected void addSpacing() {
		_sb.append(ArraysUtils.replicate(_tags.size(), TABS));
	}
	
	@Override
	public String toString() {
		if (!_isClosed) {
			close();
		}
		return _sb.toString();
	}
	

}

