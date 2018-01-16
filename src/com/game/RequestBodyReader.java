package com.game;

import java.io.BufferedReader;
import java.io.IOException;


public class RequestBodyReader {

	public static String read(BufferedReader reader) throws IOException {
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line=reader.readLine())!= null) {
			sb.append(line);
		}
		
		return sb.toString();
	}
	
}
