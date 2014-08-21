package it.riccardotraverso.java.nio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesUtils {

	private FilesUtils() {
		// Class not instantiable
	}
	
	/**
	 * Returns a string with the contents of the specified resource file.  
	 * 
	 * @param path the path to the resource file to read
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public static String readResourceAsText(String path) throws URISyntaxException, IOException {
		ClassLoader cl = FilesUtils.class.getClassLoader();
		Path p = Paths.get(cl.getResource(path).toURI());
		return new String(java.nio.file.Files.readAllBytes(p), StandardCharsets.UTF_8);
	}
	
	

}
