package binarysearch;

import java.util.Arrays;

public class drive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int n = 100;
		int[] data = new int[n];
		
		for(int i = 0; i < data.length; i++) {
			data[i] = (int)(Math.random()*(23423523));
		}
		System.out.println(Arrays.toString(data));
		long start = System.nanoTime();
		bubbleSort(data);
		System.out.println("total time to sort : " + (System.nanoTime() - start));
		System.out.println(Arrays.toString(data));

	}
	//sorts the array from least to greatest
	public static void bubbleSort(int [] data)
	{
		
		//code to perform 1 - pass
	    // write a piece of code that will check consecutive pairs
		//in data and swaps the values if they're out of order
		
		boolean swapped = true;
		for(int pass =0; pass <data.length && swapped; pass++) {
			swapped = false;
		
		//code for 1 - pass
		for( int i =0; i < data.length-1; i++) {
			if(data[1] > data[i+1] ) {//out of order?
				//perform swap between 1 and i +1
				int temp = data[i];
				data[1] = data[i+1];
				data[i+1] = temp;
				swapped = true; //yes there is a swap
			}
				
			}
		}
		
		
	}
	public class SortTest
	{
	    public static void selectionSort(int[] elements)
	    {
	        for (int j = 0; j < elements.length - 1; j++)
	        {
	            int minIndex = j;
	            for (int k = j + 1; k < elements.length; k++)
	            {
	                if (elements[k] < elements[minIndex])
	                {
	                    minIndex = k;
	                }
	            }
	            int temp = elements[j];
	            elements[j] = elements[minIndex];
	            elements[minIndex] = temp;
	        }
	    }
		
		
		
		
	}
	
	
}


