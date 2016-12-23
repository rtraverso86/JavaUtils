/*
 * Copyright (C) 2014 Riccardo Traverso
 * 
 * This file is part of JavaUtils
 * Website: https://github.com/rtraverso86/JavaUtils
 * 
 * JavaUtils is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JavaUtils is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package it.riccardotraverso.xml;

import it.riccardotraverso.java.lang.StringUtils;
import it.riccardotraverso.java.util.ArraysUtils;

import java.util.Stack;

/**
 * The <code>XmlStringBuilder</code> internally relies on the efficiency of the
 * {@link java.lang.StringBuilder} in order to build an XML document
 * and, by means of the {@link #toString()} method, conveniently convert it in a
 * string.
 * 
 * @see XmlTagOptions
 */
public class XmlStringBuilder {
	
	
	private StringBuilder _sb = new StringBuilder();
	private Stack<String> _tags = new Stack<String>();
	private boolean _isClosed = false;
	
	/** Character used for indentation */
	protected static char TABS = ' ';
	
	private static final String CLOSED_ERROR = "XML document is already closed";
	

	/**
	 * Creates a new empty <code>XmlStringBuilder</code>.
	 */
	public XmlStringBuilder() {
		initXml();
	}
	
	/**
	 * Creates a new empty <code>XmlStringBuilder</code>.
	 * 
	 * @param defaultNestingSize
	 *            The expected level of tag nesting in the XML document being
	 *            built. Only used for internal optimizations, it does not affect
	 *            the building process of the document.
	 */
	public XmlStringBuilder(int defaultNestingSize) {
		initXml();
		_tags.ensureCapacity(defaultNestingSize);
	}

	
	
	/**
	 * Adds a self-contained tag <code>&lt;tag attrs\&gt;text&lt;/tag&gt;</code>
	 * .
	 * 
	 * @param tag
	 *            the tag being added
	 * @param attrs
	 *            Eventual attributes for the tag, null or empty otherwise. This
	 *            string is directly concatenated as is into the tag opening,
	 *            e.g. if <code>tag</code> is <code>myTag</code> and
	 *            <code>attrs</code> is
	 *            <code>"myAttr='3' otherAttr='hello'"</code> then the resulting
	 *            tag being opened will be
	 *            <code>&lt;myTag myAttr='3' otherAttr='hello'&gt;</code>
	 * @param text
	 *            The contents of the tag, as a string.
	 * 
	 * @throws RuntimeException
	 *             Thrown when trying to add content to an already closed XML
	 *             document.
	 */
	public void tagWithText(String tag, String attrs, String text) {
		if (_isClosed)
			throw new RuntimeException(CLOSED_ERROR);
		initTag(tag, attrs, false);
		_sb.append('>');
		_sb.append(text);
		_sb.append("</");
		_sb.append(tag);
		_sb.append('>');
	}
	
	/**
	 * Adds a self-contained tag <code>&lt;tag&gt;text&lt;/tag&gt;</code>.
	 * 
	 * @param tag
	 *            the tag being added
	 * @param text
	 *            The contents of the tag, as a string.
	 *            
	 * @throws RuntimeException
	 *             Thrown when trying to add content to an already closed XML
	 *             document.
	 */
	public void tagWithText(String tag, String text) {
		tagWithText(tag, null, text);
	}
	
	/**
	 * Adds a self contained tag <code>&lt;tag attrs /&gt;</code>.
	 * 
	 * @param tag
	 *            the tag being added
	 * @param attrs
	 *            Eventual attributes for the tag, null or empty otherwise. This
	 *            string is directly concatenated as is into the tag opening,
	 *            e.g. if <code>tag</code> is <code>myTag</code> and
	 *            <code>attrs</code> is
	 *            <code>"myAttr='3' otherAttr='hello'"</code> then the resulting
	 *            tag being opened will be
	 *            <code>&lt;myTag myAttr='3' otherAttr='hello' /&gt;</code>
	 * 
	 * @throws RuntimeException
	 *             Thrown when trying to add content to an already closed XML
	 *             document.
	 */
	public void tag(String tag, String attrs) {
		if (_isClosed)
			throw new RuntimeException(CLOSED_ERROR);
		initTag(tag, attrs, false);
		_sb.append("/>");
	}
	
	/**
	 * Adds a self contained tag <code>&lt;tag/&gt;</code>.
	 * 
	 * @param tag
	 *            the tag being added
	 *            
	 * @throws RuntimeException
	 *             Thrown when trying to add content to an already closed XML
	 *             document.
	 */
	public void tag(String tag) {
		tag(tag, null);
	}
	
	/**
	 * Opens a new tag </code>&lt;tag options></code>.
	 * This call must be followed at some point by a matching call to {@link #closeTag()}.
	 * 
	 * @param tag
	 *  the tag being added
	 * @param attrs
	 *            Eventual attributes for the tag, null or empty otherwise. This
	 *            string is directly concatenated as is into the tag opening,
	 *            e.g. if <code>tag</code> is <code>myTag</code> and
	 *            <code>attrs</code> is
	 *            <code>"myAttr='3' otherAttr='hello'"</code> then the resulting
	 *            tag being opened will be
	 *            <code>&lt;myTag myAttr='3' otherAttr='hello'&gt;</code>
	 *            
	 * @throws RuntimeException
	 *             Thrown when trying to add content to an already closed XML
	 *             document.
	 */
	public void openTag(String tag, String attrs) {
		if (_isClosed)
			throw new RuntimeException(CLOSED_ERROR);
		initTag(tag, attrs, true);
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
	 * 
	 * @throws RuntimeException
	 *             Thrown when trying to add content to an already closed XML
	 *             document.
	 */
	public void text(String txt) {
		if (_isClosed)
			throw new RuntimeException(CLOSED_ERROR);
		_sb.append('\n');
		addSpacing();
		_sb.append(txt);
	}

	/**
	 * Closes the last tag opened, if any. If this call causes the last opened
	 * tag to be closed, the XML document itself is marked as closed and every
	 * further attempt to edit will raise a {@link java.lang.RuntimeException}.
	 * 
	 * @throws RuntimeException
	 *             Thrown when trying to close an already closed document.
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
	 * Closes all tags and the document. The XML document itself is marked as
	 * closed and every further attempt to edit will raise a
	 * {@link java.lang.RuntimeException}.
	 * 
	 * @throws RuntimeException
	 *             Thrown when trying to close an already closed document.
	 */
	public void close() {
		if (_isClosed)
			throw new RuntimeException(CLOSED_ERROR);
		while (!_tags.isEmpty()) {
			closeTag();
		}
	}
	
	
	/**
	 * Returns <code>true</code> if and only if all opened tags have been closed.
	 * Once closed, the document cannot be re-opened to edits again.
	 * 
	 */
	public boolean isClosed() {
		return _isClosed;
	}
	
	
	private void initXml() {
		initXml(null);
	}
	
	
	// Internals
	
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
	
	/**
	 * Converting the XML document being built to a string forces the closure
	 * of all tags left open and the closure of the document itself to further edits.
	 * 
	 *  @see #close()
	 */
	@Override
	public String toString() {
		if (!_isClosed) {
			close();
		}
		return _sb.toString();
	}
	

}

