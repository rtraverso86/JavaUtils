package it.riccardotraverso.java.io;

import java.io.Closeable;
import java.io.IOException;

public class CloseableUtils {

	private CloseableUtils() {
		// No instances
	}
	
	/**
	 * Closes a Closeable object without raising exceptions.
	 * 
	 * @param input
	 * @return The raised exception, if any.
	 */
	public static IOException closeQuietly(Closeable input) {
		try {
			if (input != null)
				input.close();
			return null;
		} catch (IOException e) {
			return e;
		}
	}
}
