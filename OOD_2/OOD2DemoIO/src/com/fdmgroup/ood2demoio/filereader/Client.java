package com.fdmgroup.ood2demoio.filereader;

import java.io.File;
import java.io.IOException;

public class Client {

	public static void main(String[] args) {

		File file = new File("demo.txt");

		/*
		 * Some common operations that can be called on any File instance...
		 */
		System.out.println("File 'demo.txt' exists? " + file.exists());

		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (file.exists()) {
			System.out.println(file.getAbsolutePath());
			System.out.println();
		}

		/*
		 * Can also call #delete on any File instance to remove the target file from the
		 * file system...
		 */
		//file.delete();

		ReadAndDisplay readFile = new ReadAndDisplay();
		System.out.println("Contents of target file read and written to console...\n");
		readFile.getFromSource("data/example.txt");
	}
}
