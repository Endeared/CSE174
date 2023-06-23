/* cse174 assignment5 - not quite the dictionary
   Ross Hamey
   6/19/2023 */

// scanner import for our values, our file and
// filenotfoundexception imports for opening
// / handling files
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class NotQuite {
  
  public static void main(String[] args) throws FileNotFoundException {
  
    // assigning our input scanner, validFile boolean for
    // do-while loop, and fileName string at the correct
    // scope
    Scanner input = new Scanner(System.in);
    boolean validFile = false;
    String fileName = "";
    
    // try-catch; here we prompt user for a file name,
    // check if the name is valid by trying to open the
    // file, and if it is we close the file and continue
    try {
      System.out.print("Enter a file name: ");
      fileName = input.next();
      Scanner checkFileName = new Scanner(new File(fileName));
      checkFileName.close();
    // otherwise, we throw an error and print out the
    // correct response, then end the program
    } catch (FileNotFoundException error) {
      System.out.println("Invalid file name.");
      return;
    }
    
    // setting count to 0 to get file length for declaring
    // our array
    int count = 0;
    
    // creating our initial file, iterating through each word
    // in the file, and incrementing our count
    Scanner inputFile = new Scanner(new File(fileName));
    do {
      count += 1;
      String thisWord = inputFile.next();
    } while (inputFile.hasNext());
    // close file
    inputFile.close();
    
    // open same file under different name, declare our array
    // with length of count, set i = 0 to iterate through
    // our checkFile and patch elements into array
    Scanner checkFile = new Scanner(new File(fileName));
    String[] allWords = new String[count];
    int i = 0;
    
    // do-while; we assign each word in the file to our array
    // while there is an available word, then close file
    do {
      allWords[i] = checkFile.next();
      i += 1;
    } while (checkFile.hasNext());
    checkFile.close();
    
    // create boolean for a do-while loop that identifies
    // when we are searching for a word
    boolean searchingForWord = true;
    // do-while loop, we indefinitely continue our program
    do {
      // creating another boolean for a nested do-while loop
      // which continues until the user enters "n" for our
      // search prompt
      boolean validResponse = false;
      do {
        // prompt user to search for word, y breaks out of
        // loop and continues other loop, n ends program
        System.out.print("Would you like to search for a word? (y/n): ");
        String response = input.next();
        
        if (response.equals("n")) {
          return;
        } else if (response.equals("y")) {
          validResponse = true;
        }
      } while (validResponse == false);
      
      // ask user for a word to search for, assign input to
      // string, create false boolean to check if the word is
      // found in our searches
      System.out.print("Which word would you like to find? ");
      String searchWord = input.next();
      boolean foundWord = false;
      
      // our linear search, we iterate through each word in
      // the array until one equals our searchWord and set
      // our boolean to true, otherwise it remains false
      int linearCount = 0;
      for (int j = 0; j < allWords.length; j++) {
        linearCount += 1;
        if (allWords[j].equals(searchWord)) {
          foundWord = true;
          break;
        }
      }
      
      // our binary search, we assign our int values to build
      // our search frame    
      int min = 0;
      int max = allWords.length - 1;
      int index = 0;
      int binaryCount = 0;
      // then continue our binary search until the frame is
      // searched, checking if the word at the given index
      // is equal to our searchWord, otherwise checking
      // how the word compares with respect to the compareTo
      // method and adjusting frame
      while (min <= max) {
        binaryCount += 1;
        index = (min + max) / 2;
        if (allWords[index].equals(searchWord)) {
          foundWord = true;
          break;
        } else if (allWords[index].compareTo(searchWord) < 0) {
          min = index + 1;
        } else {
          max = index - 1;
        }
      }
      
      // if our foundWord boolean is true after either search,
      // we respond accordingly. otherwise, we respond that the
      // word was not found if false
      if (foundWord == true) {
        System.out.println("File contains the word " + searchWord);
      } else {
        System.out.println("File does not contain the word " + searchWord);
      }
      
      // lastly, we print the number of comparisons for each check
      // and print a new line for formatting
      System.out.println("Linear Search for " + searchWord + ": "
          + linearCount + " comparisons");
      System.out.println("Binary Search for " + searchWord + ": "
          + binaryCount + " comparisons");
      System.out.println();
    } while (searchingForWord == true);      
  }


  
}