package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AdventDay22 {
	
	
	//turns out, all decreasing is OK Too
	//write the decreasing method which is the "opposite" of increasing
public static boolean decreasing(String [] list) {
		
		for(int i = 1; i < list.length; i++) {
			
			//check if it doesn't meet requirement, exit right away
			int el1 = Integer.valueOf(list[i]);
			int el0 = Integer.valueOf(list[i-1]);
			
			if(el1 >= el0) {
				return false;
			}
			else if(el0 - el1 > 3){ //if the difference is greater than 3!
				{
					return false;
				}
			}
		
				
			
				
		}
				//didn't find any bad pairs in loop
				return true;
	
				
	}
	
	
	
	
	public static boolean increasing(String [] list) {
		
		for(int i = 1; i < list.length; i++) {
			
			//check if it doesn't meet requirement, exit right away
			int el1 = Integer.valueOf(list[i]);
			int el0 = Integer.valueOf(list[i-1]);
			
			if(el1 <= el0) {
				return false;
			}
			else if(el1 - el0 > 3){ //if the difference is greater than 3!
				{
					return false;
				}
			}
				
										
		}
				//didn't find any bad pairs in loop
				return true;
	
				
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
			
		File file = new File("AdD2");
		try {
			Scanner scanner = new Scanner(file);
				int count = 0;
			
			while(scanner.hasNext()) {
					//grab one line
					String line = scanner.nextLine();
					
					String[] elements = line.split(" ");
					
					if(increasing (elements) || decreasing(elements)) {
						count++;
					}else {
						System.out.println(Arrays.toString(elements));
					}
					
					
					
			}
			System.out.println("TOTAL SAFE" + count);
			
		} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
	}

}