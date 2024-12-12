package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdventDay3 {

    public static void main(String[] args) {
        // Replace with the actual path to your file
        File file = new File("d3EX");

        try {
            Scanner scanner = new Scanner(file);
            int totalSum = 0;

            // Regular expression for valid mul(X,Y) instructions
            String regex = "mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)";
            Pattern pattern = Pattern.compile(regex);

            // Read each line and process it
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Find all matches of the valid mul(X,Y) pattern in the line
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    // Extract the numbers from the match
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));

                    // Calculate the product and add it to the total sum
                    totalSum += x * y;
                }
            }

            scanner.close();
            System.out.println("Sum of all valid multiplications: " + totalSum);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
