/* cse174 assignment1 - shift cipher
   Ross Hamey
   5/19/2023 */
   
// i will preface this by saying... normally i would just use
// an array / data structure to split a string into individual
// chars and iterate through them accordingly, but since that
// is much later in the book / schedule i chose to just use the
// charAt method described in 2.5.5 to assign each char individually

// scanner import for inputs
import java.util.Scanner;

public class ShiftCipher {
  public static void main(String[] args) {
    
    // initializing our input scanner
    Scanner input = new Scanner(System.in);
  
    // grabbing string input + encryption key input (#1)
    System.out.print("Enter a five letter word to encrypt: ");
    String rawInput = input.next();
    System.out.print("Enter an encryption key between 1-1000: ");
    int key = input.nextInt();
    System.out.println();
    
    // converting our key to a shift by using modulus, we use 22
    // instead of 21 because otherwise we cant get a value of 21
    // (#2)
    int shift = key % 22;
    
    // grabbing letter at each position of input string (#2)
    char firstChar = rawInput.charAt(0);
    char secondChar = rawInput.charAt(1);
    char thirdChar = rawInput.charAt(2);
    char fourthChar = rawInput.charAt(3);
    char fifthChar = rawInput.charAt(4);
    
    // getting int (ascii) value of each char and adding
    // our shift int to said value (#3)
    int firstCharPos = firstChar + shift;
    int secondCharPos = secondChar + shift;
    int thirdCharPos = thirdChar + shift;
    int fourthCharPos = fourthChar + shift;
    int fifthCharPos = fifthChar + shift;
   
    // declaring new chars by casting our int (ascii)
    // values from earlier into a char (#3)
    char newCharFirst = (char)firstCharPos;
    char newCharSecond = (char)secondCharPos;
    char newCharThird = (char)thirdCharPos;
    char newCharFourth = (char)fourthCharPos;
    char newCharFifth = (char)fifthCharPos;
    
    // concatenating all of our chars into a string format...
    // i tried just concatenating the chars alone but that did not work,
    // so i placed an empty string value in the concatenation instead
    // maybe a better way to do this, need to review data types (#4)
    String encryptedString = "" + newCharFirst + newCharSecond + newCharThird + newCharFourth + newCharFifth;
    
    // lastly, printing out the message to the user (#4)
    System.out.println("Your encrypted word is: " + encryptedString);
  }
}