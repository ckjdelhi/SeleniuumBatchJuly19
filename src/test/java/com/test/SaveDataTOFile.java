package com.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveDataTOFile {

	public static void main(String[] args) throws IOException {
		File file=new File("abc.txt");
		FileOutputStream fOut=new FileOutputStream(file);
		String string = "Hi this is automation class";
		fOut.write(string.getBytes());
		fOut.close();		
	}

}
