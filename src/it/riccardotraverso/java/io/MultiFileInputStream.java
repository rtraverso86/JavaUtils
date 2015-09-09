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

package it.riccardotraverso.java.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

/**
 * Manages multiple input files in a sequence as a single input stream, without
 * the need of concatenating them together first. When the end of file is
 * reached for a file, the stream continues looking for characters into the next
 * one (if any).
 * 
 * 
 */
public class MultiFileInputStream extends InputStream implements Closeable {
	
	private LinkedList<FileInputStream> inputs = new LinkedList<FileInputStream>();
	private FileInputStream input = null;

	/**
	 * Initializes the stream by opening the given input files in the same
	 * order.
	 * 
	 * @param files
	 * @throws IOException
	 */
	public MultiFileInputStream(File... files) throws IOException{
		if (files.length < 1) throw new IllegalArgumentException();
		for (int i = 0; i < files.length; i++) {
			inputs.add(new FileInputStream(files[i]));
		}
		nextInput();
	}
	
	/**
	 * Initializes the stream by opening the given input files in the same
	 * order.
	 * 
	 * @param paths
	 * @throws IOException
	 */
	public MultiFileInputStream(String... paths) throws IOException {
		if (paths.length < 1) throw new IllegalArgumentException();
		for (int i = 0; i < paths.length; i++) {
			inputs.add(new FileInputStream(paths[i]));
		}
		nextInput();
	}
	
	/**
	 * Initializes the stream by opening the given input files in the same
	 * order.
	 * 
	 * @param descriptors
	 * @throws IOException
	 */
	public MultiFileInputStream(FileDescriptor... descriptors) throws IOException {
		if (descriptors.length < 1) throw new IllegalArgumentException();
		for (int i = 0; i < descriptors.length; i++) {
			inputs.add(new FileInputStream(descriptors[i]));
		}
		nextInput();
	}

	@Override
	public int read() throws IOException {
		if (input == null && inputs.size() == 0) return -1;
		int r;
		do {
			r = input.read();
		} while (r < 0 && nextInput());
		return r;
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		if (input == null && inputs.size() == 0) return -1;
		if (len == 0) return 0;
		int count = 0, r;
		do {
			r = input.read(b, off, len);
			if (r > 0) {
				count += r;
				off += r;
				len -= r;
			}
		} while (count < len && nextInput());
		return count;
	}
	
	@Override
	public int available() throws IOException {
		int avail = 0;
		for (FileInputStream fis : inputs) {
			avail += fis.available();
		}
		return avail;
	}
	
	private final boolean nextInput() throws IOException {
		if (input != null) {
			input.close();
		}
		return (input = inputs.poll()) != null;
	}
	
	
	@Override
	public void close() throws IOException {
		if (input != null) {
			input.close();
		}
		while (!inputs.isEmpty()) {
			inputs.poll().close();
		}
	}
	
	

}
