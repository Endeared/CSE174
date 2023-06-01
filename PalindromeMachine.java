/* cse174 assignment2 - palindrome machine
   Ross Hamey
   6/1/2023 */

// scanner and file imports for reading inputs / file.
// we also import filenotfoundexception error and throw
// the exception in our main method if the file cannot
// be found by the system
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PalindromeMachine {
  // main throws filenotfoundexception if we run into it
  public static void main(String[] args) throws FileNotFoundException {
    
    // creating input scanner, and assigning started variable
    // for do-while loop so we can repeat the menu
    Scanner input = new Scanner(System.in);
    boolean started = false;
    
    do {
      // print out our menu and options each loop
      System.out.println("Welcome to the Palindrome Machine!");
      System.out.println("-----------------------------------");
      System.out.println("1. Read one word from the keyboard");
      System.out.println("2. Read one or more words from a file");
      System.out.println("3. Exit");
      System.out.print("Enter your selection: ");
      
      // grabbing our menu selection and turning it to a number
      String selection = input.next();
      int selectionNum = Integer.parseInt(selection);
      
      // first if check, sees if our selection is 1
      if (selectionNum == 1) {
        // if selection is 1, prompt user for a word and grab
        // word from input. then we assign an empty reversed string
        // which will be used to compare later
        System.out.print("Enter the word you would like to check: ");
        String word = input.next();
        String reversed = "";
        
        // iterate through our input word in reverse, grab each
        // character, and add it to our reversed string
        for (int i = (word.length() - 1); i >= 0; i--) {
          char thisChar = word.charAt(i);
          reversed += thisChar;
        }
        
        // if our original word equals our new reversed word after
        // the for loop, identify the word as a palindrome. otherwise,
        // tell the user it isnt. print out a new line for formatting
        if (word.equals(reversed)) {
          System.out.println(word + ": this word is a palindrome");
        } else {
          System.out.println(word + ": this word is not a palindrome");
        }
        System.out.println();
      
      // second if check, sees if our selection is 2
      } else if (selectionNum == 2) {
        
        // try-catch statement incase our user inputs an invalid file
        try {
          // we start by asking the user for a file name, then grab the
          // inputted name, and try opening the file. we then also assign
          // an empty allWords string which we will add to by iterating
          // through our file
          System.out.print("Enter the file you would like to check: ");
          String fileName = input.next();
          Scanner inputFile = new Scanner(new File(fileName));
          String allWords = "";
          
          // loop through all lines in our file and add them to our allWords
          // string. admittedly, i couldnt figure out how to do this with
          // just hasNext() and next(), because i couldnt figure out how to
          // format the whitespaces properly... instead, i used hasNextLine()
          // and nextLine() from chapter 7 in bjlo textbook
          while (inputFile.hasNextLine()) {
            String thisLine = inputFile.nextLine();
            allWords += thisLine;
          }
          
          // declare a new reversedWords string
          String reversedWords = "";
          
          // iterate through our allWords string in reverse, adding each
          // char to the reversedWords string
          for (int i = (allWords.length() - 1); i >= 0; i--) {
            char thisChar = allWords.charAt(i);
            reversedWords += thisChar;
          }
          
          // if our original allWords string equals our new reversedWords
          // string, then respond accordingly identifying the file as a
          // palindrome / not a palindrome
          if (allWords.equals(reversedWords)) {
            System.out.println(allWords + ": this file is a palindrome");
          } else {
            System.out.println(allWords + ": this file is not a palindrome");
          }
          
          // print out new line for formatting, always close file!
          System.out.println();
          inputFile.close();
          
        // if we run into an error finding the file from our user input,
        // print out an invalid file message and then a new line for
        // formatting
        } catch (FileNotFoundException error) {
          System.out.println("Invalid file");
          System.out.println();
        }  
        
      // final if check, sees if our input on the menu was 3
      } else if (selectionNum == 3) {
        // if our input was 3, break because the option was exit
        break;
        
      // lastly, if our user puts in a menu option that isnt 1, 2, or 3,
      // then simply return a message saying it was an invalid option,
      // and print a new line for formatting
      } else {
        System.out.println("Invalid menu option");
        System.out.println();
      }
    
    // end of our do-while loop. could have just used a while
    // loop but chose do-while incase i needed to add anything
    // outside of the loop
    } while (started == false);
   
  }
}