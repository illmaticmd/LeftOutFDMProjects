package com.fdmgroup.ood2demoio.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*	
 * 	Class ReadAndDisplay reads the contents of a given 
 *	text file and then displays these contents to the 
 *	console one character at a time.
 */

public class ReadAndDisplay {

	public void getFromSource(String filename) {

		File file = new File(filename);
		FileReader fileReader = null;
		
		try {
			fileReader = new FileReader(file);
			
			int c = fileReader.read();
			while (c != -1) {
				System.out.print((char) c);
				c = fileReader.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
