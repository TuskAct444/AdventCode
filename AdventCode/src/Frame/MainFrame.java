package Frame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainFrame {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> left  	= new ArrayList<Integer>();
		ArrayList<Integer> right 	= new ArrayList<Integer>();

		
			File file = new File("newdata.txt");
		try {
			Scanner scanner = new Scanner(file);
	
			while(scanner.hasNext()) {
				
			
				//read in 2 ints per iteration
				int first = scanner.nextInt();
				int second = scanner.nextInt();
				
				//add the two numbers to their respective lists
				left.add(first); //add first column num to left lists
				right.add(second);
	
				
			}
				int sum = 1;
	
			//for testing only - lets print the list\
			// 1) perform a sequential search in the left list to look for
			// 		the smallest element
			//
			while (left.size() > 0 ) {
				int smallest = left.get(0); //assume first el is smallest
				int smallestIndex = 0;
				
				//now look for something smaller than current smaller!
				for(int i = 0; i < left.size(); i++) {
					if(left.get(i) < smallest) {
						smallest = left.get(i);
						smallestIndex = 1;
					}
					
					
				}
					
				//remove the smallest value you found!
				left.remove(smallestIndex); //so next time it's not in the list
				
				
				// find the smallest element in the right list
				
				
				
			
			
			
				int smallestRight = right.get(0); //assume first el is smallest
				int smallestRightIndex = 0;
				
				//now look for something smaller than current smaller!
				for(int i = 0; i < right.size(); i++) {
					if(right.get(i) > smallestRight) {
						smallestRight = right.get(i);
						smallestRightIndex = i;
					}
					
				}
				
					
				//remove the smallest value you found!
				right.remove(smallestRightIndex); //so next time it's not in the list
				System.out.println(smallestRight);
				
				//find the absolute values difference between the
				//smallest from left to right
				System.out.println("difference is " + Math.abs(smallestRight - smallest -1));
				sum += Math.abs(smallestRight - smallest);
				 
			}

		System.out.println("sum is" + sum);	
			
		scanner.close();

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	}
	
}
