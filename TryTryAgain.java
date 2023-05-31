/* cse174 lab5 - try, try again
   Ross Hamey
   5/31/2023 */
   
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class TryTryAgain {
  public static void main(String[] args) throws FileNotFoundException {
    
    // initializing our input scanner
    Scanner input = new Scanner(System.in);
    
    boolean finished = false;
    double total = 0;
    int count = 0;
    double minimum = Integer.MAX_VALUE;
    double maximum = Integer.MIN_VALUE;
    double average = 0;
    
    do {
      try {
        System.out.print("Please enter the name of the file: ");
        String inputFile = input.next();
        Scanner file = new Scanner(new File(inputFile));
        
        while (file.hasNext()) {
          String thisVal = file.next();
          try {
            double doubleVal = Double.parseDouble(thisVal);
            total += doubleVal;
            count += 1;
            
            if (count == 1) {
              minimum = doubleVal;
              maximum = doubleVal;
              average = doubleVal;
            } else {
              if (doubleVal < minimum) {
                minimum = doubleVal;
              }
              if (doubleVal > maximum) {
                maximum = doubleVal;
              }
              
              average = total / count;
            }
            
          } catch (Exception error) {
            System.out.println("Skipping over invalid input: " + thisVal);
          }
        }
        
        finished = true;
        
      } catch (FileNotFoundException error) {
        System.out.println(error.getMessage());
      } 
    } while (finished == false);
    
    if (count < 1) {
      System.out.println("No valid data found. No stats available.");
    } else {
      System.out.println("Total: " + total);
      System.out.println("Min: " + minimum);
      System.out.println("Max: " + maximum);
      System.out.println("Average: " + average);
    }
   
  }
}