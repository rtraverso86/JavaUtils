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
package it.riccardotraverso.java.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

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
		InputStream in = cl.getResourceAsStream(path);
		BufferedReader r = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		int ch;
		while ((ch = r.read()) != -1) {
			sb.appendCodePoint(ch);
		}
		return sb.toString();
//		Path p = Paths.get(cl.getResource(path).toURI());
//		return new String(java.nio.file.Files.readAllBytes(p), StandardCharsets.UTF_8);
	}
	
	

}
