package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AdventDay3 {

	/*
	 * Extract the next multiplication command from the given line
	 * 
	 * return an empty string if none exists
	 */
	
	public  String extractMult(String line) {
		
	if(line.indexOf("mul") == -1) {
		return ""; //not valid command found in line
	} else {
		
			int start = line.indexOf("mul(");
			int end   = line.indexOf();
		
			//STOP if there is no closing ")" then
			// this is not the one we want
			
			
			
			return line.substring(start, end);
	}
		
}	
		
	public static void main(String[] args) {
			
		File file = new File("d3EX");
		try {
			Scanner scanner = new Scanner(file);
				int count = 0;
			
			while(scanner.hasNext()) {
					
					System.out.println(scanner.next());
					System.out.println("----------");
					
			}
					
				scanner.close();
			
		} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
	}
}

