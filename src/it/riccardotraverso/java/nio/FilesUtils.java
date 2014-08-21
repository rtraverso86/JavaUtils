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
