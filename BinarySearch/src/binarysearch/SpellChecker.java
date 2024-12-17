package binarysearch;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SpellChecker
{
    private ArrayList<String> dictionary;

    /* Constructor populates the dictionary ArrayList from the file dictionary.txt*/
    public SpellChecker() throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get("words.txt"));
        dictionary = new ArrayList<String>(lines);
    }

    /**
     * Write a linearSearch(word) method that finds a word
     * in the ArrayList dictionary. It should also keep
     * a count of the number of words checked.
     *
     * @param String word to be found in elements.
     * @return a count of how many words checked before returning.
     */
    public int linearSearch(String word)
    {
    	
    	for(int i = 0; i <dictionary.size(); i++){
    		
    		if(word.equals(dictionary.get(i))) {
    			return i + 1;
    		}
    		
    	}
    	
    
    	//not found
    	return dictionary.size();
    	
    	
    	
    	
    }

    /**
     * Write a binarySearch(word) method that finds the word
     * in the ArrayList dictionary. It should also keep
     * a count of the number of words checked.
     *
     * @param String word to be found in elements.
     * @return a count of how many words checked before returning.
     */
    public int binarySearch(String word) {
        int left = 0;
        int right = dictionary.size() - 1;
        int count = 0; // Count of comparisons

        while (left <= right) {
            count++; // Increment comparison count
            int middle = (left + right) / 2;

            // Compare the middle element with the target word
            int comparison = word.compareTo(dictionary.get(middle));
            if (comparison < 0) {
                right = middle - 1; // Word is in the left half
            } else if (comparison > 0) {
                left = middle + 1; // Word is in the right half
            } else {
                return count; // Word found
            }
        }
        return count; // Word not found, return comparisons made
    }
      
    	
    	
    	
    	
    		
    

    public static void main(String[] args) throws IOException
    {
        SpellChecker checker = new SpellChecker();
        String word = "shower";
        int i = checker.linearSearch(word);
        System.out.println("Linear search steps for " + word + " = " + i);
        int count = checker.binarySearch(word);
        System.out.println("Binary search steps for " + word + " = " + count);
    }
}


