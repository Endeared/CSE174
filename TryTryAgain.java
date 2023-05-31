/* cse174 lab5 - try, try again
   Ross Hamey
   5/31/2023 */

// scanner and file imports for reading inputs / file.
// we also import filenotfoundexception error which we throw
// in our main method if the file name cannot be found
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TryTryAgain {
  public static void main(String[] args) throws FileNotFoundException {
    
    // initializing our input scanner
    Scanner input = new Scanner(System.in);
    
    // declaring our initial values; finished will be used
    // to control our do-while loop, our count will be used
    // for our avg, and then we assign total / average to 0.
    // for our minimum / maximum, we use the Integer.MAX_VALUE/
    // MIN_VALUE properties from ch2.1 to start our min and max
    boolean finished = false;
    int count = 0;
    double total = 0;
    double minimum = Integer.MAX_VALUE;
    double maximum = Integer.MIN_VALUE;
    double average = 0;
    
    // displaying our initial message
    System.out.print("Please enter the name of the file: ");
    
    // our do-while loop will repeat the program until we enter
    // a valid file name
    do {
      // our main try loop, returns appropriate message when file
      // name is invalid in our catch statement. otherwise, runs 
      // the rest of the program
      try {
        // grabbing file name and assigning it to file scanner
        String inputFile = input.next();
        Scanner file = new Scanner(new File(inputFile));
        
        // while our file has another line, continue
        while (file.hasNext()) {
          // assign current line value to string
          String thisVal = file.next();
          try {
            // try converting thisVal string to a double using the
            // parseDouble method from ch2.5 and declaring it.if we
            // get an exception, we print out an appropriate message 
            // declaring that the input was skipped in our catch statement
            double doubleVal = Double.parseDouble(thisVal);
            // increment our count and add to our total val if we do
            // not run into an exception, meaning the value is a valid
            // double
            total += doubleVal;
            count += 1;
            
            // if our doubleVal is greater than minimum or less than
            // maximum, update the min / max variables accordingly
            if (doubleVal < minimum) {
              minimum = doubleVal;
            }
            if (doubleVal > maximum) {
              maximum = doubleVal;
            }
            
            // divide our running total by the running count and update
            // avg
            average = total / count;
            
          } catch (Exception error) {
            System.out.println("Skipping over invalid input: " + thisVal);
          }
        }
        
        // if our nested loop finishes successfully, we close
        // our file and set finished to true to end our do-while
        // loop
        file.close();
        finished = true;
        System.out.println();
        
      } catch (FileNotFoundException error) {
        System.out.println(error.getMessage());
        System.out.print("Please enter a valid file name: ");
      } 
    } while (finished == false);
    
    // if our count is less than 1, meaning no valid values were
    // found in our loop, we return an appropriate message
    if (count < 1) {
      System.out.println("No valid data found. No stats available.");
    // otherwise, we printf our total / min / max / avg with the
    // correct colon format and truncating each double value to
    // 2 decimal places
    } else {
      System.out.printf("Total  : %1.2f%n", total);
      System.out.printf("Min    : %1.2f%n", minimum);
      System.out.printf("Max    : %1.2f%n", maximum);
      System.out.printf("Average: %1.2f%n", average);
    }
   
  }
}