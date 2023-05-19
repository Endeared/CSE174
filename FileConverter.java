/* cse174 lab2 - file converter
   Ross Hamey
   5/19/2023 */

// scanner + printwriter + file imports for reading and
// writing inputs / outputs appropriatele, filenotfoundexception
// import for incorrect or improper file names
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class FileConverter {
  // will throw filenotfoundexception in main if sys cannot find file
  public static void main(String[] args) throws FileNotFoundException {
    
    // creating input scanner
    Scanner input = new Scanner(System.in);
    
    // grabbing inputs and declaring vars with appropriate data types (#1 + #2)
    System.out.print("Please enter the name of your input file: ");
    String inputFile = input.next();
    System.out.print("Please enter a double to use as your scaling value: ");
    double scalar = input.nextDouble();
    
    // creating file scanner with our inputFile var (#3)
    Scanner file = new Scanner(new File(inputFile));
    
    // declaring ints from our data file (#3)
    int firstNum = file.nextInt();
    int secondNum = file.nextInt();
    int thirdNum = file.nextInt();
    int fourthNum = file.nextInt();
    
    // closing our data file so we don't occupy it any longer than needed...
    file.close();
    
    // declaring scaled values from our ints & scalar (#4)
    double firstNumScaled = firstNum * scalar;
    double secondNumScaled = secondNum * scalar;
    double thirdNumScaled = thirdNum * scalar;
    double fourthNumScaled = fourthNum * scalar;
    
    // printing results - right indent of 10 + display doubles to
    // 3 decimals (#5)
    System.out.printf("%10.3f%n", firstNumScaled);
    System.out.printf("%10.3f%n", secondNumScaled);
    System.out.printf("%10.3f%n", thirdNumScaled);
    System.out.printf("%10.3f%n", fourthNumScaled);
    
    // concatenating output prefix to our inputFile string,
    // then creating output PrintWriter with our new outputTitle
    // string as the name of the file (i.e ouput_nums1.txt) (#5)
    String outputTitle = "output_" + inputFile;
    PrintWriter output = new PrintWriter(new File(outputTitle));

    // repeating the previous prints with same indent / decimal display,
    // but this time in our output file (#5)
    output.printf("%10.3f%n", firstNumScaled);
    output.printf("%10.3f%n", secondNumScaled);
    output.printf("%10.3f%n", thirdNumScaled);
    output.printf("%10.3f%n", fourthNumScaled);
    
    // cant forget to close our file to write the changes! (#5)
    output.close();
  }
}