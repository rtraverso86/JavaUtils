package it.riccardotraverso.java.lang;

/**
 * Offers the same services as a {@link java.lang.StringBuilder} (via
 * delegation), but adds a few methods to manage indentation levels. Useful to
 * print out code.
 * 
 */
public class StringBuilderIndent implements java.io.Serializable,
		java.lang.CharSequence {

	public static final char NEWLINE = '\n';

	private static final long serialVersionUID = 2262995178478038471L;

	private java.lang.StringBuilder _b = new java.lang.StringBuilder();
	private String indentation = "    ";
	private int indentationLevel = 0;
	private String currentIndentation = "";

	//
	// Constructors
	//

	/**
	 * Generate a new StringBuilder with default indentation at 4 spaces.
	 */
	public StringBuilderIndent() {
		super();
	}

	/**
	 * Generate a new StringBuilder with specified indentation.
	 * 
	 * @param indentation
	 */
	public StringBuilderIndent(String indentation) {
		super();
		this.indentation = indentation;
	}

	//
	// Delegates
	//

	/**
	 * @see java.lang.StringBuilder#append(boolean)
	 */
	public StringBuilderIndent append(boolean b) {
		_b.append(b);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(char)
	 */
	public StringBuilderIndent append(char c) {
		// if (indentationLevel > 0 && c == NEWLINE)
		// _b.append(this.currentIndentation);
		_b.append(c);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(char[], int, int)
	 */
	public StringBuilderIndent append(char[] str, int offset, int len) {
		// if (indentationLevel > 0 && ArraysUtils.contains(str, '\n')) {
		// for (int i = 0; i < str.length; i++) {
		// char c = str[i];
		// if (c == NEWLINE) {
		// _b.append(this.currentIndentation);
		// } else {
		// _b.append(c);
		// }
		// }
		// _b.append(this.currentIndentation);
		// } else {
		_b.append(str, offset, len);
		// }
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(char[])
	 */
	public StringBuilderIndent append(char[] str) {
		// if (indentationLevel > 0)
		// _b.append(this.currentIndentation);
		_b.append(str);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(java.lang.CharSequence, int, int)
	 */
	public StringBuilderIndent append(CharSequence s, int start, int end) {
		// if (indentationLevel > 0)
		// _b.append(this.currentIndentation);
		_b.append(s, start, end);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(java.lang.CharSequence)
	 */
	public StringBuilderIndent append(CharSequence s) {
		// if (indentationLevel > 0)
		// _b.append(this.currentIndentation);
		_b.append(s);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(double)
	 */
	public StringBuilderIndent append(double d) {
		_b.append(d);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(float)
	 */
	public StringBuilderIndent append(float f) {
		_b.append(f);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(int)
	 */
	public StringBuilderIndent append(int i) {
		_b.append(i);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(long)
	 */
	public StringBuilderIndent append(long lng) {
		_b.append(lng);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(java.lang.Object)
	 */
	public StringBuilderIndent append(Object obj) {
		_b.append(obj);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(java.lang.String)
	 */
	public StringBuilderIndent append(String str) {
		_b.append(str);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#append(java.lang.StringBuffer)
	 */
	public StringBuilderIndent append(StringBuffer sb) {
		_b.append(sb);
		return this;
	}

	/**
	 * @see java.lang.AbstractStringBuilder#capacity()
	 */
	public int capacity() {
		return _b.capacity();
	}

	/**
	 * @see java.lang.StringBuilder#delete(int, int)
	 */
	public StringBuilderIndent delete(int start, int end) {
		_b.delete(start, end);
		return this;
	}

	/**
	 * @see java.lang.StringBuilder#deleteCharAt(int)
	 */
	public StringBuilderIndent deleteCharAt(int index) {
		_b.deleteCharAt(index);
		return this;
	}

	/**
	 * @see java.lang.AbstractStringBuilder#ensureCapacity(int)
	 */
	public void ensureCapacity(int arg0) {
		_b.ensureCapacity(arg0);
	}

	/**
	 * @see java.lang.AbstractStringBuilder#getChars(int, int, char[], int)
	 */
	public void getChars(int arg0, int arg1, char[] arg2, int arg3) {
		_b.getChars(arg0, arg1, arg2, arg3);
	}

	/**
	 * @see java.lang.StringBuilder#indexOf(java.lang.String, int)
	 */
	public int indexOf(String str, int fromIndex) {
		return _b.indexOf(str, fromIndex);
	}

	/**
	 * @see java.lang.StringBuilder#indexOf(java.lang.String)
	 */
	public int indexOf(String str) {
		return _b.indexOf(str);
	}

	/**
	 * @see java.lang.StringBuilder#lastIndexOf(java.lang.String, int)
	 */
	public int lastIndexOf(String str, int fromIndex) {
		return _b.lastIndexOf(str, fromIndex);
	}

	/**
	 * @see java.lang.StringBuilder#lastIndexOf(java.lang.String)
	 */
	public int lastIndexOf(String str) {
		return _b.lastIndexOf(str);
	}

	/**
	 * @see java.lang.AbstractStringBuilder#setLength(int)
	 */
	public void setLength(int arg0) {
		_b.setLength(arg0);
	}

	/**
	 * @see java.lang.AbstractStringBuilder#substring(int, int)
	 */
	public String substring(int arg0, int arg1) {
		return _b.substring(arg0, arg1);
	}

	/**
	 * @see java.lang.AbstractStringBuilder#substring(int)
	 */
	public String substring(int arg0) {
		return _b.substring(arg0);
	}

	/**
	 * @see java.lang.StringBuilder#toString()
	 */
	public String toString() {
		return _b.toString();
	}

	/**
	 * @see java.lang.AbstractStringBuilder#trimToSize()
	 */
	public void trimToSize() {
		_b.trimToSize();
	}

	//
	// Specific methods
	//

	/**
	 * Adds one level of indentation. It only affects subsequent calls to {@link #newLine()}.
	 * 
	 * @return the <code>StringBuilder</code> itself
	 * @see #unindent()
	 * @see #getIndentationLevel()
	 * @see #newLine()
	 */
	public StringBuilderIndent indent() {
		this.indentationLevel++;
		this.currentIndentation += indentation;
		return this;
	}

	/**
	 * Removes one level of indentation. It only affects subsequent calls to {@link #newLine()}.
	 * 
	 * @return the <code>StringBuilder</code> itself
	 * @see #indent()
	 * @see #getIndentationLevel()
	 * @see #newLine()
	 */
	public StringBuilderIndent unindent() {
		if (indentationLevel > 0) {
			indentationLevel--;
			currentIndentation = currentIndentation.substring(0,
					currentIndentation.length() - indentation.length());
		}
		return this;
	}

	/**
	 * Returns a natural value representing the current amount of indentation,
	 * i.e. the number of times the indentation string (see
	 * {@link #StringBuilderIndent(String)}) will be printed after each call to
	 * {@link #newLine()}.
	 * 
	 * @return the indentation level
	 * @see #indent()
	 * @see #unindent()
	 * @see #newLine()
	 */
	public int getIndentationLevel() {
		return indentationLevel;
	}

	/**
	 * Adds a {@link #NEWLINE} to the string being built, appending appropriate
	 * indentation as needed. The amount indentation is
	 * {@link #getIndentationLevel()} times the indentation string (see
	 * {@link #StringBuilderIndent(String)}).
	 * 
	 * @return this object
	 * @see #indent()
	 * @see #unindent()
	 * @see #getIndentationLevel()
	 */
	public StringBuilderIndent newLine() {
		_b.append(NEWLINE);
		if (indentationLevel > 0)
			_b.append(this.currentIndentation);
		return this;
	}

	//
	// Interfaces
	//

	/**
	 * @see java.lang.CharSequence#charAt(int)
	 */
	@Override
	public char charAt(int index) {
		return _b.charAt(index);
	}

	/**
	 * @see java.lang.CharSequence#length()
	 */
	@Override
	public int length() {
		return _b.length();
	}

	/**
	 * @see java.lang.CharSequence#subSequence(int, int)
	 */
	@Override
	public CharSequence subSequence(int start, int end) {
		return _b.subSequence(start, end);
	}

}
