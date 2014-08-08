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
