/* cse174 lab4pt1 - wordle wizard
   Ross Hamey
   5/26/2023 */

// imports scanner, file, and filenotfoundexception incase our
// system cannot find the specified file
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordleWizard {
  // allows us to throw filenotfouncexception error in our main func
  // if the sys cannot find the file
  public static void main(String[] args) throws FileNotFoundException {
    
    // creating input scanner for user input
    Scanner input = new Scanner(System.in);
    
    // grabbing filename and then opening said filename with scanner,
    // assigning it to our wordfile scanner variable, then printing
    // a new line for proper formatting
    System.out.print("Please enter the name of your Wordle file: ");
    String fileName = input.next();
    Scanner wordFile = new Scanner(new File(fileName));
    System.out.println();
    
    // declaring our result string which we will add to, and our
    // word count which we will increment each time we find a
    // valid word
    String result = "";
    int wordCount = 0;
    
    // while loop that repeats anytime our wordFile has a
    // valid string next
    while (wordFile.hasNext()) {
      // in this loop, we read the next string and declare it
      // to our thisWord variable
      String thisWord = wordFile.next();
      
      // here, if thisWord has a length of 5 characters, we
      // concatenate it with our existing result string and
      // add a newline escape char. we also increment our count
      if (thisWord.length() == 5) {
        result += thisWord + "\n";
        wordCount++;
      }
      
    }
    
    // after the while loop finishes, we print our result
    // string which shows all of our valid words, and then
    // we print our final message which tells us how many
    // valid words were in our specified file name
    System.out.println(result);
    System.out.println(fileName + " contained " + wordCount 
        + " valid Wordle words.");
    
    // lastly, we must of course close our wordFile so it
    // isn't blocked in other programs
    wordFile.close();
    
  }
}